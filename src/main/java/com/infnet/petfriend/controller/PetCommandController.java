package com.infnet.petfriend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.petfriend.command.AdoptPetCommand;
import com.infnet.petfriend.service.PetCommandService;

@RestController
public class PetCommandController {

    private final PetCommandService petCommandService;

    public PetCommandController(PetCommandService petCommandService) {
        this.petCommandService = petCommandService;
    }

    @PostMapping("/adopt")
    public void adoptPet(@RequestBody AdoptPetCommand request) {
        petCommandService.adoptPet(request.getPetId(), request.getNewOwnerId());
    }
}

