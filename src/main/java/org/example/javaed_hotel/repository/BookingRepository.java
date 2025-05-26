package org.example.javaed_hotel.repository;

import org.example.javaed_hotel.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByGuestName(String guestName);
}
