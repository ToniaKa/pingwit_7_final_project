package pl.pingwit.pingwitseatreservations.exceptionhandling;

public class SeatReservNotFoundException extends RuntimeException {
    public SeatReservNotFoundException(String message) {
        super(message);
    }
}
