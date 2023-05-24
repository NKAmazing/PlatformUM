package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITripRepository extends JpaRepository<Trip, Long> {
}