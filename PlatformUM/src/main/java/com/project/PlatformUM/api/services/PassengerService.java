package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Passenger;
import com.project.PlatformUM.api.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


@Service
public class PassengerService {

    @Autowired
    IPassengerRepository passengerRepository;

    public ArrayList<Passenger> getPassengers() {
        return (ArrayList<Passenger>) passengerRepository.findAll();
    }

    public Optional<Passenger> getById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger create(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    //! Ver si se puede hacer un update de todos los campos.
    public Passenger updateById(Passenger request, Long id){
        Passenger passenger = passengerRepository.findById(id).get();

        if (request.getFullname() != null) passenger.setFullname(request.getFullname());
        if (request.getBirthdate() != null) {
            // For birthdate, we need to format it to a string.
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String formattedDate = request.getBirthdate().format(formatter);
            passenger.setBirthdate(formattedDate);
        }
        if (request.getNid() != null) passenger.setNid(request.getNid());
        if (request.getGender() != null) passenger.setGender(request.getGender());
        if (request.getSeatNumber() != null) passenger.setSeatNumber(request.getSeatNumber());

        return passengerRepository.save(passenger);
    }

    public Boolean deletePassenger (Long id) {
        try {
            passengerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}

