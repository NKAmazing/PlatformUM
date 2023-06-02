package com.project.PlatformUM.api.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.project.PlatformUM.api.services.CityService;
// import com.project.PlatformUM.api.services.CompanyService;
// import com.project.PlatformUM.api.services.DestinationService;
// import com.project.PlatformUM.api.services.PassengerService;
// import com.project.PlatformUM.api.services.ReservationService;
// import com.project.PlatformUM.api.services.TripService;
// import com.project.PlatformUM.api.services.UserService;
// import com.project.PlatformUM.api.services.VehicleService;

import ch.qos.logback.core.model.Model;


@RestController

public class AppController {
    
    // @Autowired
    // private CityService cityService;

    // @Autowired
    // private CompanyService companyService;

    // @Autowired
    // private DestinationService destinationService;

    // @Autowired
    // private PassengerService passengerService;

    // @Autowired
    // private ReservationService reservationService;

    // @Autowired
    // private TripService tripService;

    // @Autowired
    // private UserService userService;

    // @Autowired
    // private VehicleService vehicleService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

}
