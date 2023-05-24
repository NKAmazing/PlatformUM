package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}