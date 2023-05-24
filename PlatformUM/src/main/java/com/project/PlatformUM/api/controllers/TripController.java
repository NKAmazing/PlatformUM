package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.TripService;
import com.project.PlatformUM.api.models.Trip;

import java.util.List;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> getTrips() {
        return this.tripService.getAll();
    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable("id") Long id) {
        return this.tripService.getById(id);
    }

    @PostMapping
    public Trip addTrip(@RequestBody Trip trip) {
        return this.tripService.create(trip);
    }

    /*@PutMapping("/{id}")
    public Trip updateTrip(@PathVariable("id") Long id, @RequestBody Trip trip) {
        return tripService.update(id, trip);
    }*/

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable("id") Long id) {
        this.tripService.delete(id);
    }
}
