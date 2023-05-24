package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Trip;
import com.project.PlatformUM.api.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
import java.util.ArrayList;


@Service
public class TripService {
    
    @Autowired
    ITripRepository tripRepository;

    public ArrayList<Trip> getTrips() {
        return (ArrayList<Trip>) tripRepository.findAll();
    }

    public Optional<Trip> getById(Long id) {
        return tripRepository.findById(id);
    }

    public Trip create(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip updateById(Trip request, Long id){
        Trip trip = tripRepository.findById(id).get();

        trip.setDestination(request.getDestination());
        trip.setCompany(request.getCompany());

        return trip;
    }

    public Boolean deleteTrip (Long id) {
        try {
            tripRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}