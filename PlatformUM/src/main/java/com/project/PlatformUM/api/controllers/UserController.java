package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.UserService;
// import com.project.PlatformUM.api.models.Reservation;
import com.project.PlatformUM.api.models.User;
// import com.project.PlatformUM.api.models.Trip;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // private final ReservationController reservationController;

    // private final TripController tripController;

    // public UserController(ReservationController reservationController, TripController tripController) {
    //     this.reservationController = reservationController;
    //     this.tripController = tripController;
    // }

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

    // public List<Trip> searchTrips() {
    //     // Call the method to search the trips
    //     return tripController.getTrips();
    // };

    // @PostMapping("/{userId}/makeReservation")
    // public Reservation makeReservation(@PathVariable("userId") Long userId, @RequestBody Trip trip) {
    //     // Get the user
    //     Optional<User> user = getUser(userId);
    
    //     // Create a new reservation
    //     Reservation reservation = new Reservation();
    //     reservation.setUser(user.get());
    //     reservation.setTrip(trip);        

    //     // Call the method to create the reservation
    //     return reservationController.addReservation(reservation);
    // }    
}
