package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.UserService;
import com.project.PlatformUM.api.models.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return this.userService.create(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return this.userService.updateById(user, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        boolean isDeleted = this.userService.deleteUser(id);

        if (isDeleted) {
            return "City with id " + id + " was deleted.";
        } else {
            return "City with id " + id + " was not deleted.";
        }
    }
}
