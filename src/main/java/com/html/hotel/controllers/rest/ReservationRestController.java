package com.html.hotel.controllers.rest;

import java.util.List;


import com.html.hotel.entities.Customer;
import com.html.hotel.entities.Reservation;
import com.html.hotel.services.CustomerService;
import com.html.hotel.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest-reservations")
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping(value = "")
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.save(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable("id") Long id) {
        Reservation foundReservation = reservationService.findById(id);
        return new ResponseEntity<>(foundReservation, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Reservation>> getAll() {
        List<Reservation> foundReservation = reservationService.findAll();
        return new ResponseEntity<>(foundReservation, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reservation> update(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        Reservation updatedReservation = reservationService.update(id, reservation);
        return new ResponseEntity<>(updatedReservation, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        reservationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

