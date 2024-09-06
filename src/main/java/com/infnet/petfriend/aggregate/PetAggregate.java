package com.infnet.petfriend.aggregate;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.infnet.petfriend.command.AdoptPetCommand;
import com.infnet.petfriend.event.PetAdoptedEvent;

import org.axonframework.modelling.command.AggregateLifecycle;

@Aggregate
public class PetAggregate {

    @AggregateIdentifier
    private String petId;
    private String ownerId;

    public PetAggregate() {}

    @CommandHandler
    public PetAggregate(AdoptPetCommand command) {
        AggregateLifecycle.apply(new PetAdoptedEvent(command.getPetId(), command.getNewOwnerId()));
    }
}
