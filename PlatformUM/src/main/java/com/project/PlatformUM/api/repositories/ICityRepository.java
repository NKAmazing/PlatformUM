package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ICityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c WHERE c.name LIKE %?1%"
            + " OR c.state LIKE %?1%")
    public List<City> findAll(String keyWord);

}