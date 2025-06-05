package com.html.hotel.entities;


import com.html.hotel.enums.RoomType;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.Data;
//import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "room_number", nullable = false, unique = true)
    private String roomNumber;


    @Enumerated(EnumType.STRING)
    @Column(name = "room_type", nullable = false)
    private RoomType roomType;


    @Column(nullable = false)
    private Integer floor;


    @Column(nullable = false)
    private Integer capacity;


    @Column(name = "price_per_night", nullable = false, precision = 10)
    private Double pricePerNight;


    public Room() {
    }


    public Room(String roomNumber, RoomType roomType, Integer floor, Integer capacity, Double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floor = floor;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getRoomNumber() {
        return roomNumber;
    }


    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }


    public RoomType getRoomType() {
        return roomType;
    }


    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


    public Integer getFloor() {
        return floor;
    }


    public void setFloor(Integer floor) {
        this.floor = floor;
    }


    public Integer getCapacity() {
        return capacity;
    }


    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }


    public Double getPricePerNight() {
        return pricePerNight;
    }


    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
}





