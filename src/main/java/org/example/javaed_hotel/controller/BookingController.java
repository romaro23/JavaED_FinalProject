package org.example.javaed_hotel.controller;

import org.example.javaed_hotel.model.Booking;
import org.example.javaed_hotel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookingController {
    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping("/bookings")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }
    @GetMapping("/bookings/{guestName}")
    public ResponseEntity<List<Booking>> getAllBookingsByGuestName(@PathVariable String guestName) {
        Optional<Booking> booking = bookingService.getBookingByGuestName(guestName);
        if (booking.isPresent()) {
            return new ResponseEntity<>(bookingService.getAllBookingsByGuestName(guestName), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
