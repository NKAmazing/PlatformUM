package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// import java.time.LocalDateTime;
import java.util.List;


public interface ITripRepository extends JpaRepository<Trip, Long> {

    @Query("SELECT d.id, origin.name AS originCity, destination.name AS destinationCity " +
            "FROM Trip t " +
            "JOIN Destination d ON t.destination.id = d.id " +
            "JOIN City origin ON d.origin.id = origin.id " +
            "JOIN City destination ON d.destination.id = destination.id " +
            "WHERE origin.name LIKE %:keyword% " +
            "AND destination.name LIKE %:keyword2% " +
            "AND d.date >= :dateFrom")
    public List<Trip> findByInfo(@Param("keyword") String keyword, @Param("keyword2") String keyword2,
                                            @Param("dateFrom") String dateFrom);

}
