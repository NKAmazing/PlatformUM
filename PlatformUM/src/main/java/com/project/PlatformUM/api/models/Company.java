package com.project.PlatformUM.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.CascadeType;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles = new ArrayList<>();   

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Trip> trips = new ArrayList<>();

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

    @JsonIgnoreProperties({"company"})
    public List<Vehicle> getVehicle() {
        return vehicles;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicles = vehicle;
    }

    @JsonIgnoreProperties({"company"})
    public List<Trip> getTrip() {
        return trips;
    }

    public void setTrip(List<Trip> trip) {
        this.trips = trip;
    }
}
