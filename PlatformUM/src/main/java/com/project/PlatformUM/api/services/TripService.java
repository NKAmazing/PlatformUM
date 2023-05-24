package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Trip;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TripService implements IService<Trip>{
    
    public TripService() {
    }

    @Override
    public List<Trip> getAll() {
        return new ArrayList<Trip>();
    }

    @Override
    public Trip getById(Long id) {
        return new Trip();
    }

    @Override
    public Trip create(Trip trip) {
        return new Trip();
    }

    @Override
    public Trip update(Trip trip) {
        return new Trip();
    }

    @Override
    public void delete(Long id) {
    }
}
