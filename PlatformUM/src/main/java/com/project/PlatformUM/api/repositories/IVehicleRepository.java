package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
}