package pl.pingwit.pingwitseatreservations.service.booking;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingFullDto;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservNotFoundException;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.booking.BookingRepository;
import pl.pingwit.pingwitseatreservations.repository.client.Client;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    private final BookingConverter bookingConverter;


    public BookingServiceImpl(BookingRepository bookingRepository, BookingConverter bookingConverter) {
        this.bookingRepository = bookingRepository;
        this.bookingConverter = bookingConverter;
    }
    @Override
    public List<BookingDto> getClientBookings(Integer clientId) {
        Client client=new Client(clientId);
        return bookingRepository.findAllByClientId(client).stream().map(bookingConverter::convertToDto).toList();
    }
    @Override
    public Integer createBooking(CreateBookingDto createBookingDto) {
        Booking savedBooking = bookingRepository.save(bookingConverter.createBooking(createBookingDto));
        return savedBooking.getId();
    }

    @Override
    public BookingFullDto getBooking(Integer id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(()-> new SeatReservNotFoundException("Booking with id not found " + id));
        return bookingConverter.convertToFullDto(booking);
    }

}
