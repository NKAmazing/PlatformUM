package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Reservation;
import com.project.PlatformUM.api.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
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

    //! Ver si se puede hacer un update de todos los campos.
    public Reservation updateById(Reservation request, Long id){
        Reservation reservation = reservationRepository.findById(id).get();

        if (request.getUser() != null) reservation.setUser(request.getUser());
        if (request.getPrice() != null) reservation.setPrice(request.getPrice());

        return reservation;
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
