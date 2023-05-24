package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.PassengerService;
import com.project.PlatformUM.api.models.Passenger;

import java.util.List;

@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getPassengers() {
        return this.passengerService.getAll();
    }

    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable("id") Long id) {
        return this.passengerService.getById(id);
    }

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return this.passengerService.create(passenger);
    }

    /*@PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        return passengerService.update(id, passenger);
    }*/

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        this.passengerService.delete(id);
    }
}
