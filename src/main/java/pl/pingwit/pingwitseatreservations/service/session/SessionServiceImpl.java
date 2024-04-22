package pl.pingwit.pingwitseatreservations.service.session;

import jakarta.transaction.Transactional;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.session.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.UpdateSessionInputDto;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.film.FilmRepository;
import pl.pingwit.pingwitseatreservations.repository.session.Session;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final SessionConverter sessionConverter;
    private final FilmRepository filmRepository;

    public SessionServiceImpl(SessionRepository sessionRepository, SessionConverter sessionConverter, FilmRepository filmRepository) {
        this.sessionRepository = sessionRepository;
        this.sessionConverter = sessionConverter;
        this.filmRepository = filmRepository;
    }

    @Override
    public List<SessionDto> listSessions() {
        return sessionRepository.findAll().stream()
                .map(sessionConverter::convertToDto)
                .toList();
    }

    @Override
    public SessionDto getSession(Integer id) {
        Session session = sessionRepository.findById(id).orElseThrow();
        return sessionConverter.convertToDto(session);
    }

    @Override
    public Integer createSession(CreateSessionDto createSessionDto) {

        Film film = filmRepository.findById(createSessionDto.getFilm()).orElseThrow();

        LocalDateTime sessionStart = createSessionDto.getStartDateAndTime();
        LocalDateTime sessionEnd = sessionStart.plusMinutes(film.getDuration());

        List<String> intersectionErrors = sessionRepository.findAll().stream()
                .filter(session -> intervalsIntersect(sessionStart, sessionEnd, session.getStartDateAndTime(), session.getEndDateAndTime()))
                .map(session -> "Session intersects with session " + session.getId())
                .toList();

        Session savedSession = sessionRepository.save(sessionConverter.createSession(createSessionDto));
        return savedSession.getId();
    }


    private boolean intervalsIntersect(LocalDateTime start1, LocalDateTime end1,
                                       LocalDateTime start2, LocalDateTime end2) {
        return start1.isBefore(end2) && end1.isAfter(start2);
    }

    @Override
    public void updateSession(Integer id, UpdateSessionInputDto inputDto) {
        Film film = new Film();
        film.setId(inputDto.getFilm());

        Session sessionToUpdate = sessionRepository.findById(id).orElseThrow();
        sessionToUpdate.setStartDateAndTime(inputDto.getStartDateAndTime());
        sessionToUpdate.setEndDateAndTime(inputDto.getEndDateAndTime());
        sessionToUpdate.setFilm(film);
        sessionRepository.save(sessionToUpdate);
    }
}
