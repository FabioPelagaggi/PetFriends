package com.infnet.pet_friends.events;

import java.time.LocalDate;
import java.util.List;

import com.infnet.pet_friends.entities.Pet;
import com.infnet.pet_friends.entities.PetOwner;

public class PetAdoptedEvent {

    private final PetOwner petOwner;
    private final Pet pet;
    private List<Pet> availablePets;
    private List<Pet> adoptedPets;

    public PetAdoptedEvent(PetOwner petOwner, Pet pet, List<Pet> availablePets, List<Pet> adoptedPets) {
        this.petOwner = petOwner;
        this.pet = pet;
        this.availablePets = availablePets;
        this.adoptedPets = adoptedPets;
    }

    public PetOwner getPetOwner() {
        return this.petOwner;
    }

    public Pet getPet() {
        return this.pet;
    }

    public List<Pet> getAvailablePets() {
        return this.availablePets;
    }

    public List<Pet> getAdoptedPets() {
        return this.adoptedPets;
    }

    public void removePetFromAvailableList(List<Pet> availablePets, Pet pet) {
        availablePets.remove(pet);
    }

    public void addPetToAdoptedList(List<Pet> adoptedPets, Pet pet) {
        adoptedPets.add(pet);
    }

    public void addPetToOwnerList(List<Pet> pets, Pet pet) {
        pets.add(pet);
    }

    public void scheduleVetAppointment(Pet pet, LocalDate date) {
        requestAppointment(pet, date);
    }

    private void requestAppointment(Pet pet, LocalDate date) {
        System.out.println("Appointment scheduled for pet " + pet.getName() + " on " + date);
    }
}
