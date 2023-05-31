package com.project.PlatformUM.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles = new HashSet<>();   

    public Company() {
        // Empty constructor
    }

    public Company(String name, Set<Vehicle> vehicle, Trip trip) {
        this.name = name;
        this.vehicles = vehicle;
    }

    // Getters and setters of the class attributes
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

    public Set<Vehicle> getVehicle() {
        return vehicles;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicles = vehicle;
    }
}
