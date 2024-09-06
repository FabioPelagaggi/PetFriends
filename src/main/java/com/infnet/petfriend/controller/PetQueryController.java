package com.infnet.petfriend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.petfriend.event.PetAdoptedEvent;
import com.infnet.petfriend.query.PetQueryService;

import java.util.List;

@RestController
public class PetQueryController {

    private final PetQueryService petQueryService;

    public PetQueryController(PetQueryService petQueryService) {
        this.petQueryService = petQueryService;
    }

    @GetMapping("/pets/events/{petId}")
    public List<PetAdoptedEvent> getAllEventsForPet(@PathVariable String petId) {
        return petQueryService.getAllEventsForPet(petId);
    }

}
