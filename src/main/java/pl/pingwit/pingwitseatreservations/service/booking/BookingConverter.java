package pl.pingwit.pingwitseatreservations.service.booking;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateReservedSeatDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.ReservedSeatDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationNotFoundException;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.client.ClientRepository;
import pl.pingwit.pingwitseatreservations.repository.place.Place;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeat;
import pl.pingwit.pingwitseatreservations.repository.session.Session;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;
import pl.pingwit.pingwitseatreservations.service.place.PlaceConverter;
import pl.pingwit.pingwitseatreservations.service.session.SessionConverter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

@Component
public class BookingConverter {

    private final PlaceConverter placeConverter;
    private final ClientRepository clientRepository;
    private final SessionRepository sessionRepository;
    private final SessionConverter sessionConverter;


    public BookingConverter(PlaceConverter placeConverter, ClientRepository clientRepository,
                            // для читаемости рекомендую переносить строки, которые не помещаются на экран
                            SessionRepository sessionRepository, SessionConverter sessionConverter) {
        this.placeConverter = placeConverter;
        this.clientRepository = clientRepository;
        this.sessionRepository = sessionRepository;
        this.sessionConverter = sessionConverter;
    }

    public BookingDto convertToDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setClient(booking.getClient().getName());
        bookingDto.setTimeOfPurchase(booking.getTimeOfPurchase());
        bookingDto.setReservedSeats(booking.getReservedSeats().stream()
                .map(this::toReservedSeatDto)
                .toList());
        return bookingDto;
    }

    private ReservedSeatDto toReservedSeatDto(ReservedSeat reservedSeat) {
        ReservedSeatDto reservedSeatDto = new ReservedSeatDto();
        reservedSeatDto.setId(reservedSeat.getId());
        reservedSeatDto.setPlace(placeConverter.convertToDto(reservedSeat.getPlace()));
        reservedSeatDto.setFilmSession(sessionConverter.convertToDto(reservedSeat.getSession()));
        return reservedSeatDto;
    }

    public Booking convertToEntity(CreateBookingDto createBookingDto) {

        Client client = clientRepository.findById(createBookingDto.getClient()).orElseThrow(() -> new SeatReservationNotFoundException("Client with id not found " + createBookingDto.getClient()));
        Booking booking = new Booking();

        booking.setClient(client);
        booking.setTimeOfPurchase(createBookingDto.getTimeOfPurchase());
        /*Session session = createBookingDto.getReservedSeats().stream()
                .map(CreateReservedSeatDto::getSessionId)
                .findFirst()
                .flatMap(sessionRepository::findById)
                .orElseThrow(() -> new SeatReservationNotFoundException("Session with id not found " ));*/

        Integer[] sessionId = new Integer[1];
        Session session=createBookingDto.getReservedSeats().stream()
                .map(createReservedSeatDto -> {
                     sessionId[0] = createReservedSeatDto.getSessionId();
                    return sessionId[0];
                })
                .findFirst()
                .flatMap(sessionRepository::findById)
                .orElseThrow(() -> new SeatReservationNotFoundException("Session with id not found "+ sessionId[0]));

        List<ReservedSeat> reservedSeats = createBookingDto.getReservedSeats().stream()
                .map(reservedSeatDto -> {
                    Place place = new Place(reservedSeatDto.getPlaceId());
                    return new ReservedSeat(booking, session, place);
                })
                .toList();

        booking.setReservedSeats(reservedSeats);
        return booking;
    }
}
