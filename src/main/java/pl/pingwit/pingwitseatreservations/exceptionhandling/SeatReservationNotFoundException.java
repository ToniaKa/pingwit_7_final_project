package pl.pingwit.pingwitseatreservations.exceptionhandling;

public class SeatReservationNotFoundException extends RuntimeException {

    public SeatReservationNotFoundException(String message) {
        super(message);
    }
}
