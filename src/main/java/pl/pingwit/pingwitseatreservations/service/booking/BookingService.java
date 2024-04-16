package pl.pingwit.pingwitseatreservations.service.booking;

import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;

import java.util.List;

public interface BookingService {
    List<BookingDto> getClientBookings(Integer clientId);
}
