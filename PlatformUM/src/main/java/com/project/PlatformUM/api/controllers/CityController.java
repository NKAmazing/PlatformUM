package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.project.PlatformUM.api.services.CityService;

import org.springframework.ui.Model;

import com.project.PlatformUM.api.models.City;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    // TODO: Change filter in the future  to frontend. With youtube video.
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> viewHomePage(Model model, @Param("keyWord") String keyWord) {
        // String keyWord = "";
        List<City> listCities = cityService.getCities(keyWord);
        // model.addAttribute("listCities", listCities);
        // model.addAttribute("keyWord", keyWord);

        return listCities;
        // return index;
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
