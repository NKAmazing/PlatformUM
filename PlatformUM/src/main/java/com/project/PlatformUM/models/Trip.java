package com.project.PlatformUM.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Trip {

    @OneToOne(mappedBy = "trip")
    private Destination destination;

    @OneToMany(mappedBy = "trip")
    private Reservation reservations;

    @OneToOne(mappedBy = "trip")
    private Company company;


    public Trip() {
        // Empty constructor
    }

    public Trip(Destination destination, Reservation reservations, Company company) {
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

    public Reservation getReservations() {
        return reservations;
    }

    public void setReservations(Reservation reservations) {
        this.reservations = reservations;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
}
