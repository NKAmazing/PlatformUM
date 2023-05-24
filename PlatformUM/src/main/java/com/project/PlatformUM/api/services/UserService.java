package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements IService<User>{
    
    public UserService() {
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>();
    }

    @Override
    public User getById(Long id) {
        return new User();
    }

    @Override
    public User create(User user) {
        return new User();
    }

    @Override
    public User update(User user) {
        return new User();
    }

    @Override
    public void delete(Long id) {
    }

    public User getByEmail(String email) {
        return new User();
    }

    public User getByUsername(String username) {
        return new User();
    }
    
}
