package pl.pingwit.pingwitseatreservations.service.film;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.film.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.FilmFullDto;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.service.session.SessionConverter;

@Component
public class FilmConverter {
    private final SessionConverter sessionConverter;

    public FilmConverter(SessionConverter sessionConverter) {
        this.sessionConverter = sessionConverter;
    }

    public FilmDto convertToDto (Film film){
        return new FilmDto(film.getId(), film.getName(), film.getYearOfRelease());
    }
    public FilmFullDto convertToFullDto(Film film){
        FilmFullDto result=new FilmFullDto();
        result.setId(film.getId());
        result.setName(film.getName());
        result.setYearOfRelease(film.getYearOfRelease());
        result.setAgeRestrictionType(film.getAgeRestriction());
        result.setDuration(film.getDuration());
        result.setSessions(film.getSessions().stream().map(sessionConverter::convertToShortDto).toList());
        return result;
    }
    public Film convertToEntity (CreateFilmDto filmDto){
        return new Film(filmDto.getName(),filmDto.getYearOfRelease(),filmDto.getAgeRestrictionType(),filmDto.getDuration());
    }
}
