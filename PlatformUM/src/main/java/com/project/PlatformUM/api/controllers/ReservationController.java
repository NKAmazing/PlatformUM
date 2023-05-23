package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.ReservationService;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /*@GetMapping
    public List<Reservation> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") Long id) {
        return reservationService.getReservation(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
    }*/
}
