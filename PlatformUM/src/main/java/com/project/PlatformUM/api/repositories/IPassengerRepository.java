package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassengerRepository extends JpaRepository<Passenger, Long> {
}