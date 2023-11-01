package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.User;
import com.project.PlatformUM.api.repositories.IUserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.security.crypto.password.PasswordEncoder;


@Service
@RequiredArgsConstructor
public class UserService {
    
    @Autowired
    IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

    public ArrayList<User> getUsersByInfo(String keyWord) {
        return (ArrayList<User>) userRepository.findByInfo(keyWord);
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User updateById(User request, Long id){
        User user = userRepository.findById(id).get();

        if (request.getUsername() != null) user.setUsername(request.getUsername());
        if (request.getPassword() != null) user.setPassword(passwordEncoder.encode(request.getPassword()));
        if (request.getEmail() != null) user.setEmail(request.getEmail());
        if (request.getTelephone() != null) user.setTelephone(request.getTelephone());

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
    
}
