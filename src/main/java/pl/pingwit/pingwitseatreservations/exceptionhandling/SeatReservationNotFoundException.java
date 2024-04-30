package pl.pingwit.pingwitseatreservations.exceptionhandling;

public class SeatReservationNotFoundException extends RuntimeException { // SeatReserv -> SeatReservation

    public SeatReservationNotFoundException(String message) {
        super(message);
    }
}
