package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.DestinationService;
import com.project.PlatformUM.api.models.Destination;

import java.util.List;

@RestController
@RequestMapping("/api/destination")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public List<Destination> getDestinations() {
        return this.destinationService.getAll();
    }

    @GetMapping("/{id}")
    public Destination getDestination(@PathVariable("id") Long id) {
        return this.destinationService.getById(id);
    }

    @PostMapping
    public Destination addDestination(@RequestBody Destination destination) {
        return this.destinationService.create(destination);
    }

    /*@PutMapping("/{id}")
    public Destination updateDestination(@PathVariable("id") Long id, @RequestBody Destination destination) {
        return destinationService.update(id, destination);
    }*/

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable("id") Long id) {
        this.destinationService.delete(id);
    }
}
