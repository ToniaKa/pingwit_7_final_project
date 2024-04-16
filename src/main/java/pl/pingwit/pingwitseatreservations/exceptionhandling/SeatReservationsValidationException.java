package pl.pingwit.pingwitseatreservations.exceptionhandling;

public class SeatReservationsValidationException extends RuntimeException{
    public SeatReservationsValidationException(String message) {
        super(message);
    }
}
