package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.TripService;

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    /*@GetMapping
    public List<Trip> getTrips() {
        return tripService.getTrips();
    }

    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable("id") Long id) {
        return tripService.getTrip(id);
    }

    @PostMapping
    public Trip addTrip(@RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @PutMapping("/{id}")
    public Trip updateTrip(@PathVariable("id") Long id, @RequestBody Trip trip) {
        return tripService.updateTrip(id, trip);
    }

    @DeleteMapping("/{id}")
    public void deleteTrip(@PathVariable("id") Long id) {
        tripService.deleteTrip(id);
    }*/
}
