package com.example.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.miniproject.model.Pet;
import com.example.miniproject.repository.PetRepository;

import java.util.List;

@Service
@Transactional
public class PetService {
    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Long id, Pet updatedPet) {
        Pet existingPet = petRepository.findById(id).orElse(null);
        if (existingPet == null) {
            // Handle not found case
            return null;
        }

        // Update the existing pet
        existingPet.setName(updatedPet.getName());
        existingPet.setBreed(updatedPet.getBreed());
        existingPet.setLocation(updatedPet.getLocation());
        existingPet.setContact(updatedPet.getContact());
        existingPet.setDeliveryLocation(updatedPet.getDeliveryLocation());
        existingPet.setAge(updatedPet.getAge());

        return petRepository.save(existingPet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
