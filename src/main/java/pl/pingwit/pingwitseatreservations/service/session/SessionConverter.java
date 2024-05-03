package pl.pingwit.pingwitseatreservations.service.session;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.session.dto.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionShortDto;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.session.Session;

@Component
public class SessionConverter {

    public SessionDto convertToDto(Session session) {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(session.getId());
        sessionDto.setStartDateAndTime(session.getStartDateAndTime());
        sessionDto.setEndDateAndTime(session.getEndDateAndTime());
        sessionDto.setFilm(session.getFilm().getName());
        return sessionDto;
    }

    public Session convertToEntity(CreateSessionDto sessionDto) {
        Film film = new Film();
        film.setId(sessionDto.getFilm());

        Session entity = new Session();
        entity.setFilm(film);
        entity.setStartDateAndTime(sessionDto.getStartDateAndTime());
        return entity;

    }

    public SessionShortDto convertToShortDto(Session session) {
        SessionShortDto sessionShortDto = new SessionShortDto();
        sessionShortDto.setId(session.getId());
        sessionShortDto.setStartDateAndTime(session.getStartDateAndTime());
        return sessionShortDto;
    }
}
