package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Destination;
import com.project.PlatformUM.api.repositories.IDestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
import java.util.ArrayList;


@Service
public class DestinationService {

    @Autowired
    IDestinationRepository destinationRepository;

    public ArrayList<Destination> getDestinations() {
        return (ArrayList<Destination>) destinationRepository.findAll();
    }

    public Optional<Destination> getById(Long id) {
        return destinationRepository.findById(id);
    }

    public Destination create(Destination destination) {
        return destinationRepository.save(destination);
    }

    //! Ver si se puede hacer un update de todos los campos.
    public Destination updateById(Destination request, Long id){
        Destination destination = destinationRepository.findById(id).get();
        
        if (request.getTravelDuration() != null) destination.setTravelDuration(request.getTravelDuration());
        if (request.getDistance() != null) destination.setDistance(request.getDistance());
        if (request.getOrigin() != null) destination.setOrigin(request.getOrigin());
        if (request.getDestination() != null) destination.setDestination(request.getDestination());

        return destinationRepository.save(destination);
    }

    public Boolean deleteDestination (Long id) {
        try {
            destinationRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
        
}
