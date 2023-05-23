package com.project.PlatformUM.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "trip")
    @PrimaryKeyJoinColumn
    private Destination destination;

    @OneToMany(mappedBy = "trip")
    private Set<Reservation> reservations = new HashSet<>();

    @OneToOne(mappedBy = "trip")
    @PrimaryKeyJoinColumn
    private Company company;


    public Trip() {
        // Empty constructor
    }

    public Trip(Destination destination, Set<Reservation> reservations, Company company) {
        this.destination = destination;
        this.reservations = reservations;
        this.company = company;
    }

    // Getters and setters of the class attributes
    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
}
