package com.example.miniproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private String breed;
 private String location;
 private String contact;
 private String deliveryLocation;
 private int age;
public Pet(Long id, String name, String breed, String location, String contact, String deliveryLocation, int age) {
	super();
	this.id = id;
	this.name = name;
	this.breed = breed;
	this.location = location;
	this.contact = contact;
	this.deliveryLocation = deliveryLocation;
	this.age = age;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getDeliveryLocation() {
	return deliveryLocation;
}
public void setDeliveryLocation(String deliveryLocation) {
	this.deliveryLocation = deliveryLocation;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

 
}

