package pl.pingwit.pingwitseatreservations.service.booking;

import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;

public interface BookingService {
    BookingDto getBooking(Integer id);
}
