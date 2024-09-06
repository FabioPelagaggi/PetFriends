package com.infnet.petfriend.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.infnet.petfriend.command.AdoptPetCommand;

@Service
public class PetCommandService {

    private final CommandGateway commandGateway;

    public PetCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public void adoptPet(String petId, String newOwnerId) {
        AdoptPetCommand command = new AdoptPetCommand(petId, newOwnerId);
        commandGateway.send(command);
    }
}
