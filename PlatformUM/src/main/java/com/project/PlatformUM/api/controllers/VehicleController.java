package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.VehicleService;

@RestController
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    /*@GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable("id") Long id) {
        return vehicleService.getVehicle(id);
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteVehicle(id);
    }*/
}
