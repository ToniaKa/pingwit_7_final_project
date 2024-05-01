package pl.pingwit.pingwitseatreservations.validator;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateReservedSeatDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationNotFoundException;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationsValidationException;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeatsRepository;

import java.util.List;

@Component
public class BookingValidator {

    private final ReservedSeatsRepository reservedSeatsRepository;


    public BookingValidator(ReservedSeatsRepository reservedSeatsRepository) {
        this.reservedSeatsRepository = reservedSeatsRepository;
    }

    public void validateOnCreate(CreateBookingDto createBookingDto) {
        Integer sessionId = createBookingDto.getReservedSeats().stream()
                .map(CreateReservedSeatDto::getSessionId)
                .findAny()
                .orElseThrow(() -> new SeatReservationNotFoundException("No session id was provided"));

        for (CreateReservedSeatDto reservedSeat : createBookingDto.getReservedSeats()) {
            if (!reservedSeatsRepository.findAllBySessionIdAndPlaceId(sessionId, reservedSeat.getPlaceId()).isEmpty()) {
                throw new SeatReservationsValidationException("Seat already booked: ",
                        List.of("session: " + reservedSeat.getSessionId() + ", place: " + reservedSeat.getPlaceId()));
            }
        }
    }
}
