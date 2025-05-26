package org.example.javaed_hotel.repository;

import org.example.javaed_hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(long hotelId);
}
