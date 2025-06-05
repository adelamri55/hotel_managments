package com.html.hotel.controllers;

import com.html.hotel.entities.Reservation;
import com.html.hotel.services.ReservationService;

import com.html.hotel.entities.Customer;
import com.html.hotel.services.CustomerService;

import com.html.hotel.entities.Room;
import com.html.hotel.services.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoomService roomService;

    @GetMapping
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationService.findAll());
        return "list-reservations";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("reservation", new Reservation());

        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("rooms", roomService.findAll());

        return "add-reservation";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute("reservation") Reservation reservation) {
        reservationService.save(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
        return "redirect:/reservations";
    }

    @GetMapping("/edit/{id}")
    public String showEditReservationForm(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.findById(id));

        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("rooms", roomService.findAll());

        return "edit-reservation";
    }

    @PostMapping("/update/{id}")
    public String updateReservation(@PathVariable Long id, @ModelAttribute Reservation reservation) {
        reservationService.update(id, reservation);
        return "redirect:/reservations";
    }
}
