package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.CityService;
import com.project.PlatformUM.api.models.City;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return this.cityService.getCities();
    }

    @GetMapping("/{id}")
    public Optional<City> getCity(@PathVariable("id") Long id) {
        return this.cityService.getById(id);
    }

    @PostMapping
    public City addCity(@RequestBody City city) {
        return this.cityService.create(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable("id") Long id, @RequestBody City city) {
        return this.cityService.updateById(city, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable("id") Long id) {
        boolean isDeleted = this.cityService.deleteCity(id);

        if (isDeleted) {
            return "City with id " + id + " was deleted.";
        } else {
            return "City with id " + id + " was not deleted.";
        }
    }
}
