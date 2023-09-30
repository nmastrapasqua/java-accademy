package com.sideagroup.accademy.service.impl;

import com.sideagroup.accademy.dto.CelebrityDto;
import com.sideagroup.accademy.dto.GetAllCelebritiesResponseDto;
import com.sideagroup.accademy.exception.GenericServiceException;
import com.sideagroup.accademy.mapper.CelebrityMapper;
import com.sideagroup.accademy.model.Celebrity;
import com.sideagroup.accademy.repository.CelebrityRepository;
import com.sideagroup.accademy.service.CelebrityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CelebrityDbService implements CelebrityService {

    private static final Logger logger = LoggerFactory.getLogger(CelebrityService.class);
    @Autowired
    private CelebrityRepository repo;
    @Autowired
    private CelebrityMapper mapper;

    @Override
    public GetAllCelebritiesResponseDto getAll(int page, int size, String orderBy) {
        validateInput(orderBy);
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        Page<Celebrity> celebrities = repo.findAll(pageable);
        return mapper.toDto(celebrities, size);
    }

    @Override
    public Optional<CelebrityDto> getById(String id) {
        Optional<Celebrity> result = repo.findById(id);
        if (!result.isEmpty()) {
            CelebrityDto dto = mapper.toDto(result.get(), true);
            return Optional.of(dto);
        }

        return Optional.empty();
    }

    @Override
    public CelebrityDto create(CelebrityDto celebrity) {
        Optional<Celebrity> opt = repo.findById(celebrity.getId());
        if (!opt.isEmpty())
            throw new GenericServiceException("Celebrity with id " + celebrity.getId() + " already exists");
        Celebrity entity = repo.save(mapper.toEntity(celebrity));
        return mapper.toDto(entity, false);
    }

    @Override
    public Optional<CelebrityDto> update(String id, CelebrityDto celebrity) {
        Optional<Celebrity> opt = repo.findById(id);
        if (opt.isEmpty())
            return Optional.empty();

        Celebrity entity = opt.get();
        mapper.updateFromDto(entity, celebrity);
        entity = repo.save(entity);

        return Optional.of(mapper.toDto(entity, false));
    }

    @Override
    public boolean deleteById(String id) {
        logger.info("deleteById called");
        repo.deleteById(id);
        return true;
    }

    private void validateInput(String orderBy) {
        if (!"id".equals(orderBy) &&
                !"primaryName".equals(orderBy)) {
            throw new GenericServiceException("Invalid Sort field '" + orderBy + "'. Valid values are: [id, primaryName]");
        }
    }
}
