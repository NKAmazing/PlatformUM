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

    //* Adding filter by name.
    public ArrayList<Trip> getTripsByInfo(String keyWord, String keyWord2, String dateFrom) {
        if (keyWord != null && keyWord2 != null && dateFrom != null) {
            return (ArrayList<Trip>) tripRepository.findByInfo(keyWord, keyWord2, dateFrom);
        }
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

        if (request.getDestination() != null) trip.setDestination(request.getDestination());
        if (request.getCompany() != null) trip.setCompany(request.getCompany());

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