package com.html.hotel.controllers.rest;

import java.util.List;

import com.html.hotel.entities.Room;
import com.html.hotel.services.RoomService;
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
@RequestMapping("/rest-rooms")
public class RoomRestController {

    @Autowired
    private RoomService roomService;

    @PostMapping(value = "")

    public ResponseEntity<Room> create(@RequestBody Room room) {
        Room createdRoom = roomService.save(room);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Room> getById(@PathVariable("id") Long id) {
        Room foundRoom = roomService.findById(id);
        return new ResponseEntity<>(foundRoom, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Room>> getAll() {
        List<Room> foundRoom = roomService.findAll();
        return new ResponseEntity<>(foundRoom, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Room> update(@PathVariable("id") Long id, @RequestBody Room room) {
        Room updatedRoom = roomService.update(id, room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        roomService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

