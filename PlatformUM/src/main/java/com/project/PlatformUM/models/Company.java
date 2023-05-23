package com.project.PlatformUM.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

    @Column(nullable = false)

    @OneToMany(mappedBy = "company")
    private Set<Vehicle> vehicle = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Set<Trip> trip = new HashSet<>();

    public Company() {
        // Empty constructor
    }

    public Company(String name, Set<Vehicle> vehicle, Set<Trip> trip) {
        this.name = name;
        this.vehicle = vehicle;
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
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public Set<Trip> getTrip() {
        return trip;
    }

    public void setTrip(Set<Trip> trip) {
        this.trip = trip;
    }
}
