package com.infnet.pet_friends.entities;

public class Pet {
    private String id;
    private String name;
    private String animal;
    private String breed;

    public Pet(String id, String name, String animal, String breed) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.breed = breed;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAnimal() {
        return animal;
    }

    public String getBreed() {
        return breed;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", animal='" + animal + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

}
