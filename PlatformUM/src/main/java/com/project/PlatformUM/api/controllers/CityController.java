package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.CityService;
import com.project.PlatformUM.api.models.City;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return this.cityService.getAll();
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable("id") Long id) {
        return this.cityService.getById(id);
    }

    @PostMapping
    public City addCity(@RequestBody City city) {
        return this.cityService.create(city);
    }

    /*@PutMapping("/{id}")
    public City updateCity(@PathVariable("id") Long id, @RequestBody City city) {
        return cityService.update(id, city);
    }*/

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Long id) {
        this.cityService.delete(id);
    }
}
