package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Destination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DestinationService implements IService<Destination> {

    public DestinationService() {
    }

    @Override
    public List<Destination> getAll() {
        return new ArrayList<Destination>();
    }

    @Override
    public Destination getById(Long id) {
        return new Destination();
    }

    @Override
    public Destination create(Destination destination) {
        return new Destination();
    }

    @Override
    public Destination update(Destination destination) {
        return new Destination();
    }

    @Override
    public void delete(Long id) {
    }
    
    
}
