package pl.pingwit.pingwitseatreservations.service.booking;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.booking.BookingRepository;
import pl.pingwit.pingwitseatreservations.repository.client.Client;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingConverter bookingConverter;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingConverter bookingConverter) {
        this.bookingRepository = bookingRepository;
        this.bookingConverter = bookingConverter;

    }

    @Override
    public List<BookingDto> getClientBookings(Integer clientId) {
        Client client = new Client(clientId);
        Optional<Booking> allByClientId = bookingRepository.findAllByClientId(client);
        return allByClientId.stream().map(bookingConverter::convertToDto).toList();
    }

    @Override
    public Integer createBooking(CreateBookingDto createBookingDto) {
        Booking savedBooking = bookingRepository.save(bookingConverter.convertToEntity(createBookingDto));
        return savedBooking.getId();
    }

    @Override
    public BookingDto getBooking(Integer id) {
        Booking booking = bookingRepository.findById(id).orElseThrow();
        return bookingConverter.convertToDto(booking);
    }

}
