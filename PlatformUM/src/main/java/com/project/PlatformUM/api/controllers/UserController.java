package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.UserService;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import com.project.PlatformUM.api.models.User;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping(value = "/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers(Model model, @Param("keyWord") String keyWord) {
        // String keyWord = "";
        List<User> listUsers = userService.getUsersByInfo(keyWord);
        // model.addAttribute("listUsers", listUsers);
        // model.addAttribute("keyWord", keyWord);

        return listUsers;
        // return index;
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
            return "User with id " + id + " was deleted.";
        } else {
            return "User with id " + id + " was not deleted.";
        }
    }  
}
