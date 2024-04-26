package pl.pingwit.pingwitseatreservations.service.session;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.session.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.UpdateSessionInputDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservNotFoundException;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.film.FilmRepository;
import pl.pingwit.pingwitseatreservations.repository.session.Session;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;
import pl.pingwit.pingwitseatreservations.validator.SessionValidator;

import java.util.List;
@Transactional
@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final SessionConverter sessionConverter;
    private final SessionValidator sessionValidator;

    public SessionServiceImpl(SessionRepository sessionRepository, SessionConverter sessionConverter, SessionValidator sessionValidator) {
        this.sessionRepository = sessionRepository;
        this.sessionConverter = sessionConverter;
        this.sessionValidator = sessionValidator;
    }

    @Override
    public List<SessionDto> listSessions() {
        return sessionRepository.findAll().stream()
                .map(sessionConverter::convertToDto)
                .toList();
    }

    @Override
    public SessionDto getSession(Integer id) {
        Session session = sessionRepository.findById(id).orElseThrow(()-> new SeatReservNotFoundException("Session with id not found " + id));
        return sessionConverter.convertToDto(session);
    }

    @Override
    public Integer createSession(CreateSessionDto createSessionDto) {
        sessionValidator.validateOnCreate(createSessionDto);
        Session savedSession = sessionRepository.save(sessionConverter.createSession(createSessionDto));
        return savedSession.getId();
    }

    @Override
    public void updateSession(Integer id, UpdateSessionInputDto inputDto) {
        sessionValidator.validateOnUpdate(inputDto);
        Film film = new Film();
        film.setId(inputDto.getFilm());

        Session sessionToUpdate = sessionRepository.findById(id).orElseThrow(()-> new SeatReservNotFoundException("Session with id not found " + id));
        sessionToUpdate.setStartDateAndTime(inputDto.getStartDateAndTime());
        sessionToUpdate.setEndDateAndTime(inputDto.getEndDateAndTime());
        sessionToUpdate.setFilm(film);
        sessionRepository.save(sessionToUpdate);
    }
}
