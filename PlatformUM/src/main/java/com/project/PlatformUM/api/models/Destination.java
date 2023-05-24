package com.project.PlatformUM.api.models;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.CascadeType;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "destination")
    @PrimaryKeyJoinColumn
    private City origin;

    @OneToOne(mappedBy = "destination")
    @PrimaryKeyJoinColumn
    private City destination;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Float travelDuration;

    @Column(nullable = false)
    private Float distance;

    @OneToOne(mappedBy = "destination")
    private Trip trip;

    public Destination(City origin, City destination, Float travelDuration, Float distance, Trip trip) {
        this.origin = origin;
        this.destination = destination;
        this.date = LocalDateTime.now();
        this.travelDuration = travelDuration;
        this.distance = distance;
        this.trip = trip;
    }

    // Getters and setters of the class attributes
    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public Float getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(Float travelDuration) {
        this.travelDuration = travelDuration;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}