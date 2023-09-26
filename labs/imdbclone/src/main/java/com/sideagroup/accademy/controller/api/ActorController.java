package com.sideagroup.accademy.controller.api;

import com.sideagroup.accademy.dto.ActorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/actors")
public class ActorController {

    // Per i più esperti, non badate a queste variabili;
    // Il controller evolverà durante il corso.
    private List<ActorDto> actors = new ArrayList<>();
    private long lasdtId = 0;

    @GetMapping
    public Iterable<ActorDto> getAll() {
        return actors;
    }

    @GetMapping("{id}")
    public ActorDto getById(@PathVariable long id) {
        Optional<ActorDto> opt = actors.stream().filter(item->item.getId() == id).findFirst();

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        return opt.get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActorDto create(@RequestBody ActorDto actor) {
        lasdtId++;
        actor.setId(lasdtId);
        actors.add(actor);
        return actor;
    }

    @PutMapping("{id}")
    public ActorDto update(@PathVariable long id, @RequestBody ActorDto actor) {
        Optional<ActorDto> opt = actors.stream().filter(item->item.getId() == id).findFirst();

        if (opt.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found");

        ActorDto myActor = opt.get();
        myActor.setFirstName(actor.getFirstName());
        myActor.setLastName(actor.getLastName());
        myActor.setDateOfBirth(actor.getDateOfBirth());

        return myActor;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        Optional<ActorDto> opt = actors.stream().filter(item->item.getId() == id).findFirst();

        if (!opt.isEmpty())
            actors.remove(opt.get());
    }
}
