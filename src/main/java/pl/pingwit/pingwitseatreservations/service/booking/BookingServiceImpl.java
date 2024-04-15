package pl.pingwit.pingwitseatreservations.service.booking;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.booking.BookingRepository;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.client.ClientRepository;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    private final BookingConverter bookingConverter;


    public BookingServiceImpl(BookingRepository bookingRepository, BookingConverter bookingConverter) {
        this.bookingRepository = bookingRepository;
        this.bookingConverter = bookingConverter;

    }
    @Override
    public BookingDto getBooking(Integer id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        return bookingConverter.convertToDto(booking);
    }
}
