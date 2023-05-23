package com.project.PlatformUM.models;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Trip trip;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Number price;

    @Column(nullable = false)
    @OneToMany(mappedBy = "reservation")
    private Set<Passenger> passengers = new HashSet<>();

    public Reservation() {
        // Empty constructor
    }

    public Reservation(User user, Trip trip, String status, LocalDate date, Number price, Set<Passenger> passengers) {
        this.user = user;
        this.trip = trip;
        this.status = status;
        this.date = date;
        this.price = price;
        this.passengers = passengers;
    }

    // Getters and setters of the class attributes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passenger) {
        this.passengers = passenger;
    }

}
