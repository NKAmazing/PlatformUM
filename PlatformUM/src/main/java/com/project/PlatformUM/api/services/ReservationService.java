package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Reservation;
import com.project.PlatformUM.api.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;


@Service
public class ReservationService {

    @Autowired
    private IReservationRepository reservationRepository;

    public ArrayList<Reservation> getReservations() {
        return (ArrayList<Reservation>) reservationRepository.findAll();
    }

    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateById(Reservation request, Long id){
        Reservation reservation = reservationRepository.findById(id).get();

        if (request.getUser() != null) reservation.setUser(request.getUser());
        if (request.getTrip() != null) reservation.setTrip(request.getTrip());
        if (request.getStatus() != null) reservation.setStatus(request.getStatus());
        if (request.getPrice() != null) reservation.setPrice(request.getPrice());
        if (request.getPassengers() != null) reservation.setPassengers(request.getPassengers());

        return reservationRepository.save(reservation);
    }

    public Boolean deleteReservation (Long id) {
        try {
            reservationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
