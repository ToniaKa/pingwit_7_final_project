package pl.pingwit.pingwitseatreservations.service.booking;

import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingFullDto;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;

import java.util.List;

public interface BookingService {
    List<BookingDto> getClientBookings(Integer clientId);
    Integer createBooking(CreateBookingDto createBookingDto);
    BookingFullDto getBooking(Integer id);
}
