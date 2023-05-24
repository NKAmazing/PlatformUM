package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class VehicleService implements IService<Vehicle>{
    
    public VehicleService() {
    }

    @Override
    public List<Vehicle> getAll() {
        return new ArrayList<Vehicle>();
    }

    @Override
    public Vehicle getById(Long id) {
        return new Vehicle();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return new Vehicle();
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return new Vehicle();
    }

    @Override
    public void delete(Long id) {
    }

}
