package com.infnet.pet_friends.controllers;

import java.util.List;

import com.infnet.pet_friends.entities.Pet;
import com.infnet.pet_friends.entities.PetOwner;

public class PetOwnerController {

    private PetOwner petOwner;

    public PetOwnerController() {
        this.petOwner = new PetOwner("1", "João", "Rua A, 123");
        Pet pet1 = new Pet("1", "Rex", "Dog", "Golden Retriever");
        Pet pet2 = new Pet("2", "Mingau", "Cat", "Siamese");
        petOwner.addPet(pet1);
        petOwner.addPet(pet2);
    }

    public PetOwner getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }

    public void addPet(Pet pet) {
        petOwner.addPet(pet);
    }

    public List<String> getPetIds() {
        return petOwner.getPetIds();
    }

    public void removePet(String id) {
        List<Pet> pets = petOwner.getPets();
        pets.removeIf(pet -> pet.getId().equals(id));
        petOwner.setPets(pets);
    }

    public Pet getPet(String id) {
        return petOwner.getPets().stream().filter(pet -> pet.getId().equals(id)).findFirst().orElse(null);
    }

    public void updatePet(Pet pet) {
        List<Pet> pets = petOwner.getPets();
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId().equals(pet.getId())) {
                pets.set(i, pet);
                break;
            }
        }
        petOwner.setPets(pets);
    }

    public void updatePetOwner(PetOwner petOwner) {
        this.petOwner = petOwner;
    }
    
}
