package pl.pingwit.pingwitseatreservations.service.session;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.session.dto.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.UpdateSessionDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationNotFoundException;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
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
        Session session = sessionRepository.findById(id).orElseThrow(() -> new SeatReservationNotFoundException("Session with id not found " + id));
        return sessionConverter.convertToDto(session);
    }

    @Override
    public Integer createSession(CreateSessionDto createSessionDto) {
        sessionValidator.validateOnCreate(createSessionDto);
        Session savedSession = sessionRepository.save(sessionConverter.convertToEntity(createSessionDto));
        return savedSession.getId();
    }

    @Override
    public void updateSession(Integer id, UpdateSessionDto inputDto) {
        sessionValidator.validateOnUpdate(inputDto);
        Film film = new Film();
        film.setId(inputDto.getFilm());

        Session sessionToUpdate = sessionRepository.findById(id).orElseThrow(() -> new SeatReservationNotFoundException("Session with id not found " + id));
        sessionToUpdate.setStartDateAndTime(inputDto.getStartDateAndTime());
        sessionToUpdate.setEndDateAndTime(inputDto.getEndDateAndTime());
        sessionToUpdate.setFilm(film);
        sessionRepository.save(sessionToUpdate);
    }
}
