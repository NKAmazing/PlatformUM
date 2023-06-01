package com.project.PlatformUM.api.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "city_origin_id")
    private City origin;

    @OneToOne
    @JoinColumn(name = "city_destination_id")
    private City destination;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Float travelDuration;

    @Column(nullable = false)
    private Float distance;

    @OneToOne(mappedBy = "destination", cascade = CascadeType.ALL)
    private Trip trip;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // This method is called before the object is persisted in the database
    @PrePersist
    public void prePersist() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String date = LocalDateTime.now().format(formatter);
        this.date = LocalDateTime.parse(date, formatter);
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

    @JsonIgnoreProperties({"destination"})
    public City getOrigin() {
        return origin;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    @JsonIgnoreProperties({"destination"})
    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }
}