package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.City;
import com.project.PlatformUM.api.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;


@Service
public class CityService {
    
    @Autowired
    ICityRepository cityRepository;

    public ArrayList<City> getCities() {
        return (ArrayList<City>) cityRepository.findAll();
    }

    public ArrayList<City> getCitiesByName(String keyword) {
        return (ArrayList<City>) cityRepository.findByName(keyword);
    }

    public Optional<City> getById(Long id) {
        return cityRepository.findById(id);
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City updateById(City request, Long id){
        City city = cityRepository.findById(id).get();

        if (request.getName() != null) city.setName(request.getName());
        if (request.getState() != null) city.setState(request.getState());

        return cityRepository.save(city);
    }

    public Boolean deleteCity (Long id) {
        try {
            cityRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
