package com.example.petproject;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository <Pet, Long> {

}
