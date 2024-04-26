package pl.pingwit.pingwitseatreservations.validator;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.session.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.UpdateSessionInputDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservNotFoundException;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationsValidationException;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.film.FilmRepository;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SessionValidator {
    private final FilmRepository filmRepository;
    private final SessionRepository sessionRepository;

    public SessionValidator(FilmRepository filmRepository, SessionRepository sessionRepository) {
        this.filmRepository = filmRepository;
        this.sessionRepository = sessionRepository;
    }

    public void validateOnCreate(CreateSessionDto sessionDto) {
        Film film = filmRepository.findById(sessionDto.getFilm()).orElseThrow(() -> new SeatReservNotFoundException("Film not found "));

        LocalDateTime sessionStart = sessionDto.getStartDateAndTime();
        LocalDateTime sessionEnd = sessionStart.plusMinutes(film.getDuration());

        List<String> intersectionErrors = sessionRepository.findAll().stream()
                .filter(session -> intervalsIntersect(sessionStart, sessionEnd, session.getStartDateAndTime(), session.getEndDateAndTime()))
                .map(session -> "Session intersects with session " + session.getId())
                .toList();

        if (!intersectionErrors.isEmpty()) {
            throw new SeatReservationsValidationException("Intersection is invalid ", intersectionErrors);
        }


    }

    public void validateOnUpdate(UpdateSessionInputDto inputDto) {
        Film film = filmRepository.findById(inputDto.getFilm()).orElseThrow(() -> new SeatReservNotFoundException("Film not found "));

        LocalDateTime sessionStart = inputDto.getStartDateAndTime();
        LocalDateTime sessionEnd = sessionStart.plusMinutes(film.getDuration());

        List<String> intersectionErrors = sessionRepository.findAll().stream()
                .filter(session -> intervalsIntersect(sessionStart, sessionEnd, session.getStartDateAndTime(), session.getEndDateAndTime()))
                .map(session -> "Session intersects with session " + session.getId())
                .toList();

        if (!intersectionErrors.isEmpty()) {
            throw new SeatReservationsValidationException("Intersection is invalid ", intersectionErrors);
        }

    }

    private boolean intervalsIntersect(LocalDateTime start1, LocalDateTime end1,
                                       LocalDateTime start2, LocalDateTime end2) {
        return start1.isBefore(end2) && end1.isAfter(start2);
    }
}
