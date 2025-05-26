package org.example.javaed_hotel.service;

import org.example.javaed_hotel.model.Booking;
import org.example.javaed_hotel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
    public List<Booking> getAllBookingsByGuestName(String guestName) {
        return bookingRepository.findByGuestName(guestName);
    }
    public Optional<Booking> getBookingByGuestName(String guestName) {
        return bookingRepository.findByGuestName(guestName).stream().findFirst();
    }
}
