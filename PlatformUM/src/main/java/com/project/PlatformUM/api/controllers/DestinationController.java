package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.DestinationService;

import lombok.RequiredArgsConstructor;

import com.project.PlatformUM.api.models.Destination;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/destinations")
@RequiredArgsConstructor
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public List<Destination> getDestinations() {
        return this.destinationService.getDestinations();
    }
    
    @GetMapping("/{id}")
    public Optional<Destination> getDestination(@PathVariable("id") Long id) {
        return this.destinationService.getById(id);
    }

    @PostMapping
    public Destination addDestination(@RequestBody Destination destination) {
        return this.destinationService.create(destination);
    }

    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable("id") Long id, @RequestBody Destination destination) {
        return this.destinationService.updateById(destination, id);
    }

    @DeleteMapping("/{id}")
    public String deleteDestination(@PathVariable("id") Long id) {
        boolean isDeleted = this.destinationService.deleteDestination(id);

        if (isDeleted) {
            return "Destination with id " + id + " was deleted.";
        } else {
            return "Destination with id " + id + " was not deleted.";
        }
    }
}
