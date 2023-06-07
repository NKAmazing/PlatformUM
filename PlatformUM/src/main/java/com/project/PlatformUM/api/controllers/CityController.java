package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.project.PlatformUM.api.services.CityService;

import ch.qos.logback.core.model.Model;

import com.project.PlatformUM.api.models.City;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    // TODO: Change filter in the future  to frontend. With youtube video.
    @GetMapping()
    public List<City> getCities() {
        return this.cityService.getCities();
    }

    @GetMapping(value = "/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCitiesByName(Model model, @PathVariable("keyword") String keyword) {
        return this.cityService.getCitiesByName(keyword);
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
