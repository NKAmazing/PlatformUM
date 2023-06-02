package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.PassengerService;
import com.project.PlatformUM.api.models.Passenger;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getPassengers() {
        return this.passengerService.getPassengers();
    }

    @GetMapping("/{id}")
    public Optional<Passenger> getPassenger(@PathVariable("id") Long id) {
        return this.passengerService.getById(id);
    }

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return this.passengerService.create(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        return this.passengerService.updateById(passenger, id);
    }

    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable("id") Long id) {
        boolean isDeleted = this.passengerService.deletePassenger(id);

        if (isDeleted) {
            return "Passenger with id " + id + " was deleted.";
        } else {
            return "Passenger with id " + id + " was not deleted.";
        }
    }
}
