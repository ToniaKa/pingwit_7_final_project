package pl.pingwit.pingwitseatreservations.service.session;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.session.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.UpdateSessionInputDto;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.session.Session;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository  sessionRepository;
    private final SessionConverter sessionConverter;

    public SessionServiceImpl(SessionRepository sessionRepository, SessionConverter sessionConverter) {
        this.sessionRepository = sessionRepository;
        this.sessionConverter = sessionConverter;
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
        Session savedSession = sessionRepository.save(sessionConverter.createSession(createSessionDto));
        return savedSession.getId();
    }

    @Override
    public void updateSession(Integer id, UpdateSessionInputDto inputDto) {
        Film film=new Film();
        film.setId(inputDto.getFilm());

        Session sessionToUpdate = sessionRepository.findById(id).orElseThrow();
        sessionToUpdate.setStartDateAndTime(inputDto.getStartDateAndTime());
        sessionToUpdate.setEndDateAndTime(inputDto.getEndDateAndTime());
        sessionToUpdate.setFilm(film);
        sessionRepository.save(sessionToUpdate);
    }
}
