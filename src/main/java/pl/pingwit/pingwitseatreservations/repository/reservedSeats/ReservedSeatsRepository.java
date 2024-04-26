package pl.pingwit.pingwitseatreservations.repository.reservedSeats;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateReservedSeatDto;
import pl.pingwit.pingwitseatreservations.controller.booking.ReservedSeatDto;

public interface ReservedSeatsRepository extends JpaRepository<ReservedSeat,Integer> {
    boolean findBySessionAndPlace(CreateReservedSeatDto createReservedSeatDto);

}
