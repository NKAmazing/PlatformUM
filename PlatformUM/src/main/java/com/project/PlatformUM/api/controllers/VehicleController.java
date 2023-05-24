package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.VehicleService;
import com.project.PlatformUM.api.models.Vehicle;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return this.vehicleService.getAll();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable("id") Long id) {
        return this.vehicleService.getById(id);
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return this.vehicleService.create(vehicle);
    }

    /*@PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.update(id, vehicle);
    }*/

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") Long id) {
        this.vehicleService.delete(id);
    }
}
