package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReservationService implements IService<Reservation>{

    public ReservationService() {
    }

    @Override
    public List<Reservation> getAll() {
        return new ArrayList<Reservation>();
    }

    @Override
    public Reservation getById(Long id) {
        return new Reservation();
    }

    @Override
    public Reservation create(Reservation reservation) {
        return new Reservation();
    }

    @Override
    public Reservation update(Reservation reservation) {
        return new Reservation();
    }

    @Override
    public void delete(Long id) {
    }
    
}
