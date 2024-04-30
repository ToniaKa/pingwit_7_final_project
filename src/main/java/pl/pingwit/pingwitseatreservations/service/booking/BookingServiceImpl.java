package pl.pingwit.pingwitseatreservations.service.booking;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationNotFoundException;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.booking.BookingRepository;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.validator.BookingValidator;

import java.util.List;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingConverter bookingConverter;
    private final BookingValidator bookingValidator;


    public BookingServiceImpl(BookingRepository bookingRepository, BookingConverter bookingConverter, BookingValidator bookingValidator) {
        this.bookingRepository = bookingRepository;
        this.bookingConverter = bookingConverter;
        this.bookingValidator = bookingValidator;
    }

    @Override
    public List<BookingDto> getClientBookings(Integer clientId) {
        Client client = new Client(clientId);
        List<Booking> allByClientId = bookingRepository.findAllByClientId(client);
        return allByClientId.stream().map(bookingConverter::convertToDto).toList();
    }

    @Override
    public Integer createBooking(CreateBookingDto createBookingDto) {
        bookingValidator.validateOnCreate(createBookingDto);
        Booking savedBooking = bookingRepository.save(bookingConverter.convertToEntity(createBookingDto));
        return savedBooking.getId();
    }

    @Override
    public BookingDto getBooking(Integer id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new SeatReservationNotFoundException("Booking with id not found " + id));
        return bookingConverter.convertToDto(booking);
    }
}
