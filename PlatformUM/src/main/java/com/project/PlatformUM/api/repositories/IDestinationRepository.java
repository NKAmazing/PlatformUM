package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDestinationRepository extends JpaRepository<Destination, Long> {
}