package com.sideagroup.accademy.controller.api;

import com.sideagroup.accademy.dto.CelebrityDto;
import com.sideagroup.accademy.dto.GetAllCelebritiesResponseDto;
import com.sideagroup.accademy.exception.GenericServiceException;
import com.sideagroup.accademy.service.CelebrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/celebrities")
public class CelebrityController {

    @Autowired
    private CelebrityService service;

    @GetMapping
    public GetAllCelebritiesResponseDto getAll(
            @RequestParam(name="page", required=false, defaultValue="0") int page,
            @RequestParam(name="size", required=false, defaultValue="20") int size,
            @RequestParam(name="order_by", required=false, defaultValue="id") String orderBy) {
        try {
            return service.getAll(page, size, orderBy);
        } catch(GenericServiceException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}")
    public CelebrityDto getById(@PathVariable String id) {
        Optional<CelebrityDto> opt = service.getById(id);

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CelebrityDto create(@RequestBody CelebrityDto celebrity) {

        try {
            return service.create(celebrity);
        } catch (GenericServiceException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("{id}")
    public CelebrityDto update(@PathVariable String id, @RequestBody CelebrityDto celebrity) {
        Optional<CelebrityDto> opt = service.update(id, celebrity);

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }
}
