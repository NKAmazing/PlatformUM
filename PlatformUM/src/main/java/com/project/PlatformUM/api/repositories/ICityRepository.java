package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepository extends JpaRepository<City, Long> {
}