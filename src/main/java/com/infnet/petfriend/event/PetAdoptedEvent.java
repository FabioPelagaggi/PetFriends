package com.infnet.petfriend.event;

public class PetAdoptedEvent extends BaseEvent {
    private final String petId;
    private final String newOwnerId;

    public PetAdoptedEvent(String petId, String newOwnerId) {
        super(petId);
        this.petId = petId;
        this.newOwnerId = newOwnerId;
    }

    public String getPetId() {
        return petId;
    }

    public String getNewOwnerId() {
        return newOwnerId;
    }
}

