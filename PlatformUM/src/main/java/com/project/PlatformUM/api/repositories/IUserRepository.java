package com.project.PlatformUM.api.repositories;

import com.project.PlatformUM.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    //!REVISAR
    User findByEmail(String email);
    User findByUsername(String username);
}