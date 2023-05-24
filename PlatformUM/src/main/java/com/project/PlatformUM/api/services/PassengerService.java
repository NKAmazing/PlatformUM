package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Passenger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PassengerService implements IService<Passenger>{

    public PassengerService() {
    }

    public List<Passenger> getAll() {
        return new ArrayList<Passenger>();
    }

    public Passenger getById(Long id) {
        return new Passenger();
    }

    public Passenger create(Passenger passenger) {
        return new Passenger();
    }

    public Passenger update(Passenger passenger) {
        return new Passenger();
    }

    public void delete(Long id) {
    }
    
}
