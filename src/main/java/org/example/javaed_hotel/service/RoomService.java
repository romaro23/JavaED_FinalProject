package org.example.javaed_hotel.service;

import org.example.javaed_hotel.model.Booking;
import org.example.javaed_hotel.model.Room;
import org.example.javaed_hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room room) {
        for (Booking booking : room.getBookings()) {
            booking.setRoom(room);
        }
        return roomRepository.save(room);
    }
    public List<Room> getRoomsByHotelId(long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
}
