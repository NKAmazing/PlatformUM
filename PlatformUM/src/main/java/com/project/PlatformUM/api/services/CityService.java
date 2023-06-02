package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.City;
import com.project.PlatformUM.api.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
import java.util.ArrayList;


@Service
public class CityService {
    
    @Autowired
    ICityRepository cityRepository;

    public ArrayList<City> getCities() {
        return (ArrayList<City>) cityRepository.findAll();
    }

    public Optional<City> getById(Long id) {
        return cityRepository.findById(id);
    }

    public City create(City city) {
        return cityRepository.save(city);
    }

    public City updateById(City request, Long id){
        City city = cityRepository.findById(id).get();

        city.setName(request.getName());
        city.setState(request.getState());

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
