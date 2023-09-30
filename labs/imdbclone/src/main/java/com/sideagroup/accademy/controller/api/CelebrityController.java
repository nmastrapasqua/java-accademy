package com.sideagroup.accademy.controller.api;

import com.sideagroup.accademy.dto.CelebrityDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/actors")
public class CelebrityController {

    // Per i più esperti, non badate a queste variabili;
    // Il controller evolverà durante il corso.
    private List<CelebrityDto> actors = new ArrayList<>();
    private long lasdtId = 0;

    @GetMapping
    public Iterable<CelebrityDto> getAll() {
        return actors;
    }

    @GetMapping("{id}")
    public CelebrityDto getById(@PathVariable String id) {
        Optional<CelebrityDto> opt = actors.stream().filter(item->item.getId().equals(id)).findFirst();

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CelebrityDto create(@RequestBody CelebrityDto actor) {
        lasdtId++;
        actor.setId(String.valueOf(lasdtId));
        actors.add(actor);
        return actor;
    }

    @PutMapping("{id}")
    public CelebrityDto update(@PathVariable String id, @RequestBody CelebrityDto actor) {
        Optional<CelebrityDto> opt = actors.stream().filter(item->item.getId().equals(id)).findFirst();

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        CelebrityDto myActor = opt.get();
        myActor.setName(actor.getName());

        return myActor;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        Optional<CelebrityDto> opt = actors.stream().filter(item->item.getId().equals(id)).findFirst();

        if (!opt.isEmpty())
            actors.remove(opt.get());
    }
}
