package pl.pingwit.pingwitseatreservations.validator;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateReservedSeatDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationsValidationException;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeatsRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceValidator {
    private final ReservedSeatsRepository reservedSeatsRepository;

    public PlaceValidator(ReservedSeatsRepository reservedSeatsRepository) {
        this.reservedSeatsRepository = reservedSeatsRepository;
    }


    public void validateOnCreate(CreateReservedSeatDto createReservedSeatDto) {

        List<String> errors = new ArrayList<>();

        if (reservedSeatsRepository.findBySessionAndPlace(createReservedSeatDto)) {
            errors.add("This place is already booked");
        }
        if (!errors.isEmpty()) {
            throw new SeatReservationsValidationException("ReservedSeat is invalid ", errors);
        }

    }
}
