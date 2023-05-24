package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Vehicle;
import com.project.PlatformUM.api.repositories.IVehicleRepository;
import org.intellij.lang.annotations.JdkConstants.AdjustableOrientation;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;


@Service
public class VehicleService {
    
    @AdjustableOrientation
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

        vehicle.setName(request.getName());
        vehicle.setType(request.getType());

        return vehicle;
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
