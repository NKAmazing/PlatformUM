package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.ReservationService;
import com.project.PlatformUM.api.models.Reservation;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getReservations() {
        return this.reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id") Long id) {
        return this.reservationService.getById(id);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return this.reservationService.create(reservation);
    }

    /*@PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        return reservationService.update(id, reservation);
    }*/

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") Long id) {
        this.reservationService.delete(id);
    }
}
