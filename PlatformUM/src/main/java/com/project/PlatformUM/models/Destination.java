package com.project.PlatformUM.models;

import java.time.LocalDateTime;

public class Destination {
    private City origin;
    private City destination;
    private LocalDateTime date;
    private Number travelDuration;
    private Number distance;


    public Destination() {
        // Empty constructor
    }

    public Destination(City origin, City destination, LocalDateTime date, Number travelDuration, Number distance) {
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.travelDuration = travelDuration;
        this.distance = distance;
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Number getTravelDuration() {
        return travelDuration;
    }

    public void setTravelDuration(Number travelDuration) {
        this.travelDuration = travelDuration;
    }

    public Number getDistance() {
        return distance;
    }

    public void setDistance(Number distance) {
        this.distance = distance;
    }
}