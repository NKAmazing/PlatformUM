package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITripRepository extends JpaRepository<Trip, Long> {

        @Query(
                value = "SELECT * FROM Trip T " +
                        "WHERE (SELECT D.date FROM destination D WHERE D.id = T.destination_id) LIKE %:date% " +
                        "AND (SELECT C.name FROM city C WHERE C.id = (SELECT D.city_origin_id FROM destination D WHERE D.id = T.destination_id)) = :origin " +
                        "AND (SELECT C.name FROM city C WHERE C.id = (SELECT D.city_destination_id FROM destination D WHERE D.id = T.destination_id)) = :destination",
                nativeQuery = true
            )
            public List<Trip> findByInfo(@Param("origin") String origin, @Param("destination") String destination, @Param("date") String date);
            
}
