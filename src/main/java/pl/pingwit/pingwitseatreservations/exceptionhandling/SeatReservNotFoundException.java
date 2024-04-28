package pl.pingwit.pingwitseatreservations.exceptionhandling;

public class SeatReservNotFoundException extends RuntimeException { // SeatReserv -> SeatReservation

    public SeatReservNotFoundException(String message) {
        super(message);
    }

}
