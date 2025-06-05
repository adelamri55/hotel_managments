package com.html.hotel.services;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.html.hotel.entities.Room;
import com.html.hotel.repositories.RoomRepository;


@Service
@Transactional
public class RoomService {


    @Autowired
    private RoomRepository roomRepository;


    public Room save(Room room) {
        return roomRepository.save(room);
    }


    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Unable to find room with id " + id));
    }


    public List<Room> findAll() {
        return roomRepository.findAll();
    }


    public Room update(Long id, Room roomUpdate) {
        Room foundRoom = findById(id);
        foundRoom.setRoomNumber(roomUpdate.getRoomNumber());
        foundRoom.setRoomType(roomUpdate.getRoomType());
        foundRoom.setFloor(roomUpdate.getFloor());
        foundRoom.setCapacity(roomUpdate.getCapacity());
        foundRoom.setPricePerNight(roomUpdate.getPricePerNight());
        return save(foundRoom);
    }


    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    public long count() {
        return roomRepository.count();
    }
}

