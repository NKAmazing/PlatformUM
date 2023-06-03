package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u FROM User u WHERE u.username LIKE %?1%"
            + " OR u.email LIKE %?1%"
            + " OR u.telephone LIKE %?1%")
    public List<User> findAll(String keyWord);
    
    
    //!REVISAR
    // User findByEmail(String email);
    // User findByUsername(String username);
}