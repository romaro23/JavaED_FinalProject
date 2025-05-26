package org.example.javaed_hotel.service;

import org.example.javaed_hotel.model.Hotel;
import org.example.javaed_hotel.model.Room;
import org.example.javaed_hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel addHotel(Hotel hotel) {
        for (Room room : hotel.getRooms()) {
            room.setHotel(hotel);
        }
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> getHotelById(long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
