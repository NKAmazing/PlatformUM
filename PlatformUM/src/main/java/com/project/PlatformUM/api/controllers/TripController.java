package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.TripService;
import com.project.PlatformUM.api.models.Trip;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> getTrips() {
        return this.tripService.getTrips();
    }

    @GetMapping("/{id}")
    public Optional<Trip> getTrip(@PathVariable("id") Long id) {
        return this.tripService.getById(id);
    }

    @PostMapping
    public Trip addTrip(@RequestBody Trip trip) {
        return this.tripService.create(trip);
    }

    @PutMapping("/{id}")
    public Trip updateTrip(@PathVariable("id") Long id, @RequestBody Trip trip) {
        return this.tripService.updateById(trip, id);
    }

    @DeleteMapping("/{id}")
    public String deleteTrip(@PathVariable("id") Long id) {
        boolean isDeleted = this.tripService.deleteTrip(id);

        if (isDeleted) {
            return "Object with id " + id + " was deleted.";
        } else {
            return "Object with id " + id + " was not deleted.";
        }
    }
}
