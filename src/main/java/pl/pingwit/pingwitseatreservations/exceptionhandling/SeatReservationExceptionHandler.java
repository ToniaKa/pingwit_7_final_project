package pl.pingwit.pingwitseatreservations.exceptionhandling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class SeatReservationExceptionHandler {

    @ExceptionHandler(SeatReservationNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(SeatReservationNotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(SeatReservationsValidationException.class)
    public ResponseEntity<String> handleValidationException(SeatReservationsValidationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(e.toString());
    }
}
