package pl.pingwit.pingwitseatreservations.service.film;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.film.dto.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmFullDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.UpdateFilmInputDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservNotFoundException;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.film.FilmRepository;

import java.util.List;

@Transactional
@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;
    private final FilmConverter filmConverter;

    public FilmServiceImpl(FilmRepository filmRepository, FilmConverter filmConverter) {
        this.filmRepository = filmRepository;
        this.filmConverter = filmConverter;
    }

    @Override
    public List<FilmDto> listFilms() {
        return filmRepository.findAll().stream()
                .map(filmConverter::convertToDto)
                .toList();
    }

    @Override
    public FilmFullDto getFilm(Integer id) {
        Film film = filmRepository.findById(id).orElseThrow(() -> new SeatReservNotFoundException("Film with id not found " + id));
        return filmConverter.convertToFullDto(film);
    }

    @Override
    public Integer createFilm(CreateFilmDto filmDto) {
        Film savedFilm = filmRepository.save(filmConverter.convertToEntity(filmDto));
        return savedFilm.getId();
    }

    @Override
    public void updateFilm(Integer id, UpdateFilmInputDto inputDto) {
        Film filmToUpdate = filmRepository.findById(id).orElseThrow(() -> new SeatReservNotFoundException("Film with id not found " + id));
        filmToUpdate.setName(inputDto.getName());
        filmToUpdate.setYearOfRelease(inputDto.getYearOfRelease());
        filmToUpdate.setAgeRestriction(inputDto.getAgeRestrictionType());
        filmToUpdate.setDuration(inputDto.getDuration());
        filmRepository.save(filmToUpdate);
    }
}
