package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CityService implements IService<City>{
    
    public CityService() {
    }

    @Override
    public List<City> getAll() {
        return new ArrayList<City>();
    }

    @Override
    public City getById(Long id) {
        return new City();
    }

    @Override
    public City create(City city) {
        return new City();
    }

    @Override
    public City update(City city) {
        return new City();
    }

    @Override
    public void delete(Long id) {
    }

}
