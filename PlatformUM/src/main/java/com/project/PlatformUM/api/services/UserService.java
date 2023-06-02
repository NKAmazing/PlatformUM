package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.User;
import com.project.PlatformUM.api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
import java.util.ArrayList;


@Service
public class UserService {
    
    @Autowired
    IUserRepository userRepository;

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    //! Verificar si se necesitan todos los campos
    public User updateById(User request, Long id){
        User user = userRepository.findById(id).get();

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setIsAdmin(request.getIsAdmin());
        user.setEmail(request.getEmail());
        user.setTelephone(request.getTelephone());

        return userRepository.save(user);
    }

    public Boolean deleteUser (Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
}
