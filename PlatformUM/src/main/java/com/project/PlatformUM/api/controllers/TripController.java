package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.TripService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;

import com.project.PlatformUM.api.models.Trip;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/trips")
@RequiredArgsConstructor
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> getTrips() {
        return this.tripService.getTrips();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Trip> getTrips(Model model, @Param("cityOriginKey") String cityOriginKey,
            @Param("cityDestinationKey") String cityDestinationKey, @Param("dateFrom") String dateFrom) {
        // String keyWord = "";
        List<Trip> listTrips = tripService.getTripsByInfo(cityOriginKey, cityDestinationKey, dateFrom);
        // model.addAttribute("listTrips", listTrips);
        // model.addAttribute("keyWord", keyWord);

        return listTrips;
        // return index;
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
            return "Trip with id " + id + " was deleted.";
        } else {
            return "Trip with id " + id + " was not deleted.";
        }
    }
}
