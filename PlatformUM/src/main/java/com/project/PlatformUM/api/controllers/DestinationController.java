package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.DestinationService;

@RestController
@RequestMapping("/api/destination")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    /*@GetMapping
    public List<Destination> getDestinations() {
        return destinationService.getDestinations();
    }

    @GetMapping("/{id}")
    public Destination getDestination(@PathVariable("id") Long id) {
        return destinationService.getDestination(id);
    }

    @PostMapping
    public Destination addDestination(@RequestBody Destination destination) {
        return destinationService.addDestination(destination);
    }

    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable("id") Long id, @RequestBody Destination destination) {
        return destinationService.updateDestination(id, destination);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable("id") Long id) {
        destinationService.deleteDestination(id);
    }*/
}
