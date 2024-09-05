package com.infnet.pet_friends.events;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class DomainEventPublisher {
    private final LocalDateTime occurredOn;

    protected DomainEventPublisher() {
        this.occurredOn = LocalDateTime.now();
    }

    public LocalDateTime occurredon() {
        return this.occurredOn;
    }

    public static void publish(PetAdoptedEvent event) {
        event.removePetFromAvailableList(event.getAvailablePets(), event.getPet());
        event.addPetToAdoptedList(event.getAdoptedPets(), event.getPet());
        event.addPetToOwnerList(event.getPetOwner().getPets(), event.getPet());
        event.scheduleVetAppointment(event.getPet(), LocalDate.now());
    }
}
