package com.html.hotel.controllers;

import com.html.hotel.services.AddressService;
import com.html.hotel.services.CustomerService;
import com.html.hotel.services.ReservationService;
import com.html.hotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("customerCount", customerService.count());
        model.addAttribute("roomCount", roomService.count());
        model.addAttribute("reservationCount", reservationService.count());
        model.addAttribute("addressCount", addressService.count());
        return "home";
    }
}