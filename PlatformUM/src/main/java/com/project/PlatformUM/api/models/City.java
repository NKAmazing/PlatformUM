package com.project.PlatformUM.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    @OneToOne(mappedBy = "origin", cascade = CascadeType.ALL)
    private Destination origin;

    @OneToOne(mappedBy = "destination", cascade = CascadeType.ALL)
    private Destination destination;

    public City() {
        // Empty constructor
    }

    public City(String name, String state, Destination destination, Destination origin) {
        this.name = name;
        this.state = state;
        this.destination = destination;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Destination getOrigin() {
        return origin;
    }

    public void setOrigin(Destination origin) {
        this.origin = origin;
    }
}
