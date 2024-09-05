package com.infnet.pet_friends.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.infnet.pet_friends.events.DomainEventPublisher;
import com.infnet.pet_friends.events.PetAdoptedEvent;

public class PetOwner {

    private String id;
    private String name;
    private String address;
    private List<Pet> pets;

    public PetOwner(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.pets = new ArrayList<Pet>();

    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public List<String> getPetIds() {
        return pets.stream().map(Pet::getId).collect(Collectors.toList());
    }

    public void adoptPet(PetAdoptedEvent petAdoptedEvent) {
        DomainEventPublisher.publish(petAdoptedEvent);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "PetOwner{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pets=" + pets +
                '}';
    }
}