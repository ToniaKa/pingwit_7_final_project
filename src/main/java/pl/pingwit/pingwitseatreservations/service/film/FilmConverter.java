package pl.pingwit.pingwitseatreservations.service.film;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.film.dto.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmFullDto;
import pl.pingwit.pingwitseatreservations.repository.film.AgeRestrictionType;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.service.session.SessionConverter;

@Component
public class FilmConverter {

    private final SessionConverter sessionConverter;


    public FilmConverter(SessionConverter sessionConverter) {
        this.sessionConverter = sessionConverter;
    }

    public FilmDto convertToDto(Film film) {
        return new FilmDto(film.getId(), film.getName(), film.getYearOfRelease());
    }

    public FilmFullDto convertToFullDto(Film film) {
        FilmFullDto result = new FilmFullDto();
        result.setId(film.getId());
        result.setName(film.getName());
        result.setYearOfRelease(film.getYearOfRelease());
        result.setAgeRestrictionType(film.getAgeRestriction());
        result.setDuration(film.getDuration());
        result.setSessions(film.getSessions().stream().map(sessionConverter::convertToShortDto).toList());
        return result;
    }

    public Film convertToEntity(CreateFilmDto filmDto) {
        Film film = new Film();
        film.setName(filmDto.getName());
        film.setYearOfRelease(filmDto.getYearOfRelease());
        film.setAgeRestriction(AgeRestrictionType.valueOf(filmDto.getAgeRestrictionTypeDto().name()));
        film.setDuration(filmDto.getDuration());
        return film;
    }
}
