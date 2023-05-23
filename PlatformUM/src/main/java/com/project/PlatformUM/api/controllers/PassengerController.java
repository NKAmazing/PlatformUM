package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.PassengerService;

@RestController
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    /*@GetMapping
    public List<Passenger> getPassengers() {
        return passengerService.getPassengers();
    }

    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable("id") Long id) {
        return passengerService.getPassenger(id);
    }

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") Long id, @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(id, passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        passengerService.deletePassenger(id);
    }*/
}
