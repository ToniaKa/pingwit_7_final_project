package pl.pingwit.pingwitseatreservations.service.film;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.film.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.FilmFullDto;
import pl.pingwit.pingwitseatreservations.controller.film.UpdateFilmInputDto;
import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.SessionShortDto;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.film.FilmRepository;
import pl.pingwit.pingwitseatreservations.repository.session.Session;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;
import pl.pingwit.pingwitseatreservations.service.session.SessionConverter;

import java.util.List;
@Transactional
@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmConverter filmConverter;
    private final SessionRepository sessionRepository;
    private final SessionConverter sessionConverter;

    public FilmServiceImpl(FilmRepository filmRepository, FilmConverter filmConverter, SessionRepository sessionRepository, SessionConverter sessionConverter) {
        this.filmRepository = filmRepository;
        this.filmConverter = filmConverter;
        this.sessionRepository = sessionRepository;
        this.sessionConverter = sessionConverter;
    }

    @Override
    public List<FilmDto> listFilms() {
        return filmRepository.findAll().stream()
                .map(filmConverter::convertToDto)
                .toList();
    }

    @Override
    public FilmFullDto getFilm(Integer id) {
        Film film = filmRepository.findById(id).orElseThrow();
        return filmConverter.convertToFullDto(film);
    }

    @Override
    public Integer createFilm(CreateFilmDto filmDto) {
        Film savedFilm = filmRepository.save(filmConverter.convertToEntity(filmDto));
        return savedFilm.getId();
    }

    @Override
    public void updateFilm(Integer id, UpdateFilmInputDto inputDto) {
        Film filmToUpdate = filmRepository.findById(id).orElseThrow();
        filmToUpdate.setName(inputDto.getName());
        filmToUpdate.setYearOfRelease(inputDto.getYearOfRelease());
        filmToUpdate.setAgeRestriction(inputDto.getAgeRestrictionType());
        filmToUpdate.setDuration(inputDto.getDuration());
        filmRepository.save(filmToUpdate);
    }
}
