package com.html.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.html.hotel.entities.Reservation;
import com.html.hotel.repositories.ReservationRepository;


@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Unable to find reservation with id " + id));
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation update(Long id, Reservation reservationUpdate) {
        Reservation foundReservation = findById(id);
        foundReservation.setCheckInDate(reservationUpdate.getCheckInDate());
        foundReservation.setCheckOutDate(reservationUpdate.getCheckOutDate());
        foundReservation.setTotalPrice(reservationUpdate.getTotalPrice());
        foundReservation.setNumberOfGuests(reservationUpdate.getNumberOfGuests());
        foundReservation.setCustomer(reservationUpdate.getCustomer());
        foundReservation.setRoom(reservationUpdate.getRoom());
        return save(foundReservation);
    }

    public void deleteById(Long id) { reservationRepository.deleteById(id); }

    public long count() {
        return reservationRepository.count();
    }
}

