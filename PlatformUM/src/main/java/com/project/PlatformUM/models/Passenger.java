package com.project.PlatformUM.models;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(nullable = false)
    private Number nid;

    @Column(nullable = false)
    private String gender;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;    

    @Column(nullable = false)
    private Number seatNumber;

    public Passenger() {
        // Empty constructor
    }

    public Passenger(String fullname, LocalDate birthdate, Number nid, String gender, Reservation reservation, Number seatNumber) {
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.nid = nid;
        this.gender = gender;
        this.reservation = reservation;
        this.seatNumber = seatNumber;
    }

    // Getters and setters of the class attributes
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Number getNid() {
        return nid;
    }

    public void setNid(Number nid) {
        this.nid = nid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender  = gender;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservations) {
        this.reservation = reservations;
    }

    public Number getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Number seatNumber) {
        this.seatNumber = seatNumber;
    }

}
