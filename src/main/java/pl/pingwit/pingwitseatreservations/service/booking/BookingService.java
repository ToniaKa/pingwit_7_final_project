package pl.pingwit.pingwitseatreservations.service.booking;

import pl.pingwit.pingwitseatreservations.controller.booking.dto.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateBookingDto;

import java.util.List;

public interface BookingService {
    List<BookingDto> getClientBookings(Integer clientId);

    Integer createBooking(CreateBookingDto createBookingDto);

    BookingDto getBooking(Integer id);
}
