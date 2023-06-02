package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Vehicle;
import com.project.PlatformUM.api.repositories.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;


@Service
public class VehicleService {
    
    @Autowired
    IVehicleRepository vehicleRepository;

    public ArrayList<Vehicle> getVehicles() {
        return (ArrayList<Vehicle>) vehicleRepository.findAll();
    }

    public Optional<Vehicle> getById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateById(Vehicle request, Long id){
        Vehicle vehicle = vehicleRepository.findById(id).get();


        if (request.getName() != null) vehicle.setName(request.getName());
        if (request.getType() != null) vehicle.setType(request.getType());
        if (request.getSeats() != null) vehicle.setSeats(request.getSeats());
        if (request.getCompany() != null) vehicle.setCompany(request.getCompany());

        return vehicleRepository.save(vehicle);
    }

    public Boolean deleteVehicle (Long id) {
        try {
            vehicleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
