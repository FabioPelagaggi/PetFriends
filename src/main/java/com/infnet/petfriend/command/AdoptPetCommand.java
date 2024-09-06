package com.infnet.petfriend.command;

public class AdoptPetCommand extends BaseCommand {
    private final String petId;
    private final String newOwnerId;

    public AdoptPetCommand(String petId, String newOwnerId) {
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
