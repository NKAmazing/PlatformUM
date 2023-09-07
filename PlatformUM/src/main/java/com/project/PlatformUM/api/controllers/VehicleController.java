package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.VehicleService;

import lombok.RequiredArgsConstructor;

import com.project.PlatformUM.api.models.Vehicle;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return this.vehicleService.getVehicles();
    }

    @GetMapping("/{id}")
    public Optional<Vehicle> getVehicle(@PathVariable("id") Long id) {
        return this.vehicleService.getById(id);
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return this.vehicleService.create(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable("id") Long id, @RequestBody Vehicle vehicle) {
        return this.vehicleService.updateById(vehicle, id);
    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable("id") Long id) {
        boolean isDeleted = this.vehicleService.deleteVehicle(id);

        if (isDeleted) {
            return "Vehicle with id " + id + " was deleted.";
        } else {
            return "Vehicle with id " + id + " was not deleted.";
        }
    }
}
