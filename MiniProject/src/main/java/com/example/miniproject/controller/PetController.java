package com.example.miniproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.miniproject.model.Pet;
import com.example.miniproject.repository.PetRepository;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin
public class PetController {
 @Autowired
 private PetRepository petRepository;

 // Get all pets
 
 @GetMapping
 public ResponseEntity<List<Pet>> getAllPets() {
     List<Pet> pets = petRepository.findAll();
     return ResponseEntity.ok(pets);
 }

 // Create a new pet
 
 @PostMapping
 public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
     Pet savedPet = petRepository.save(pet);
     return ResponseEntity.ok(savedPet);
 }

 // Update a pet
 
 @PutMapping("/{id}")
 public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
     Pet existingPet = petRepository.findById(id).orElse(null);
     if (existingPet == null) {
         return ResponseEntity.notFound().build();
     }
     
     // Update the existing pet
     
     existingPet.setName(updatedPet.getName());
     existingPet.setBreed(updatedPet.getBreed());
     existingPet.setLocation(updatedPet.getLocation());
     existingPet.setContact(updatedPet.getContact());
     existingPet.setDeliveryLocation(updatedPet.getDeliveryLocation());
     existingPet.setAge(updatedPet.getAge());

     Pet savedPet = petRepository.save(existingPet);
     return ResponseEntity.ok(savedPet);
 }

 // Delete a pet
 
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deletePet(@PathVariable Long id) {
     petRepository.deleteById(id);
     return ResponseEntity.noContent().build();
 }
}

