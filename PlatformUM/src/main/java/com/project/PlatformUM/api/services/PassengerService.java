package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Passenger;
import com.project.PlatformUM.api.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
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

        passenger.setFullname(request.getFullname());
        passenger.setNid(request.getNid());

        return passenger;
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
