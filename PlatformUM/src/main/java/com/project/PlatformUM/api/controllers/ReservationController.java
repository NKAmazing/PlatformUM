package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.ReservationService;

import lombok.RequiredArgsConstructor;

import com.project.PlatformUM.api.models.Reservation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getReservations() {
        return this.reservationService.getReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Long id) {
        return this.reservationService.getById(id);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return this.reservationService.create(reservation);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        return this.reservationService.updateById(reservation, id);
    }

    @DeleteMapping("/{id}")
    public String deleteReservation(@PathVariable("id") Long id) {
        boolean isDeleted = this.reservationService.deleteReservation(id);

        if (isDeleted) {
            return "Reservation with id " + id + " was deleted.";
        } else {
            return "Reservation with id " + id + " was not deleted.";
        }
    }
}
