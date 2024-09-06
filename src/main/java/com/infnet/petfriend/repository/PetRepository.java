package com.infnet.petfriend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infnet.petfriend.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, String> {
}