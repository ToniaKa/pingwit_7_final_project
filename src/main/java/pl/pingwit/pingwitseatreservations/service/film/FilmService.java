package pl.pingwit.pingwitseatreservations.service.film;

import pl.pingwit.pingwitseatreservations.controller.film.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.FilmFullDto;
import pl.pingwit.pingwitseatreservations.controller.film.UpdateFilmInputDto;
import pl.pingwit.pingwitseatreservations.repository.film.Film;

import java.util.List;

public interface FilmService {
    List<FilmDto> listFilms();
    FilmFullDto getFilm(Integer id);
    Integer createFilm(CreateFilmDto filmDto);
    void updateFilm(Integer id, UpdateFilmInputDto inputDto);
}
