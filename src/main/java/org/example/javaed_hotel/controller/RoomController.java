package org.example.javaed_hotel.controller;

import org.example.javaed_hotel.model.Hotel;
import org.example.javaed_hotel.model.Room;
import org.example.javaed_hotel.service.HotelService;
import org.example.javaed_hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomController {
    private final RoomService roomService;
    private final HotelService hotelService;
    @Autowired
    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }
    @GetMapping("/rooms/by-hotel/{hotelId}")
    public ResponseEntity<List<Room>> getAllRoomsByHotelId(@PathVariable long hotelId) {
        Optional<Hotel> hotel = hotelService.getHotelById(hotelId);
        if(hotel.isPresent()) {
            return new ResponseEntity<>(roomService.getRoomsByHotelId(hotelId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }
}
