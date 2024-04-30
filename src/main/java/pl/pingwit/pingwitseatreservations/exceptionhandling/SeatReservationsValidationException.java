package pl.pingwit.pingwitseatreservations.exceptionhandling;

import java.util.List;

public class SeatReservationsValidationException extends RuntimeException {

    private final List<String> violations;

    public SeatReservationsValidationException(String message, List<String> violations) {
        super(message);
        this.violations = violations;
    }

    public List<String> getViolations() {
        return violations;
    }

    @Override
    public String toString() {
        return getMessage() + " : " +
                "violations=" + violations;
    }
}

