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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;


@Entity
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "city_origin_id", nullable = false)
    private City origin;

    @ManyToOne
    @JoinColumn(name = "city_destination_id", nullable = false)
    private City destination;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Float travelDuration;

    @Column(nullable = false)
    private Float distance;

    @OneToOne(mappedBy = "destination")
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
        if (this.date != null) {
            return;
        }

        this.date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        String dateStr = this.date.format(formatter);
        this.date = LocalDateTime.parse(dateStr, formatter);
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

    @JsonIgnoreProperties({"destination"})
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

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
}