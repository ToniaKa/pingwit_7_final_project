package pl.pingwit.pingwitseatreservations.service.film;

import pl.pingwit.pingwitseatreservations.controller.film.dto.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmFullDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.UpdateFilmDto;

import java.util.List;

public interface FilmService {

    List<FilmDto> listFilms();

    FilmFullDto getFilm(Integer id);

    Integer createFilm(CreateFilmDto filmDto);

    void updateFilm(Integer id, UpdateFilmDto inputDto);
}
