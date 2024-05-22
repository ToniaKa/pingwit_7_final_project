package pl.pingwit.pingwitseatreservations.validator;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitseatreservations.controller.session.dto.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationsValidationException;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.film.FilmRepository;
import pl.pingwit.pingwitseatreservations.repository.session.Session;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SessionValidatorTest {

    private final FilmRepository filmRepository = mock(FilmRepository.class);
    private final SessionRepository sessionRepository = mock(SessionRepository.class);

    private final SessionValidator target = new SessionValidator(filmRepository, sessionRepository);

    @Test
    void shouldReturnExceptionWhenSessionsOverlap() {
        CreateSessionDto createSessionDto = new CreateSessionDto();
        createSessionDto.setId(1);

        Film film = new Film();
        film.setId(1);
        film.setSessions(List.of(new Session(LocalDateTime.of(2025, 1, 1, 10, 30),
                LocalDateTime.of(2025, 1, 1, 12, 0))));
        film.setName("Test name");
        film.setDuration(120);

        createSessionDto.setFilm(1);
        createSessionDto.setStartDateAndTime(LocalDateTime.of(2025, 1, 1, 10, 30));


        when(filmRepository.findById(1)).thenReturn(Optional.of(film));
        when(sessionRepository.findAll()).thenReturn(List.of(new Session(LocalDateTime.of(2025, 1, 1, 10, 0),
                LocalDateTime.of(2025, 1, 1, 12, 0))));

        assertThrows(SeatReservationsValidationException.class,
                () -> target.validateOnCreate(createSessionDto));
    }
}