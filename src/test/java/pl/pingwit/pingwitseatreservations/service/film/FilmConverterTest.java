package pl.pingwit.pingwitseatreservations.service.film;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitseatreservations.controller.film.dto.AgeRestrictionTypeDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmFullDto;
import pl.pingwit.pingwitseatreservations.repository.film.AgeRestrictionType;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.service.session.SessionConverter;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class FilmConverterTest {

    private final SessionConverter sessionConverter=mock(SessionConverter.class);

    private final FilmConverter target= new FilmConverter(sessionConverter);

    @Test
    void shouldFilmFullDto() {
        Film film=new Film();
        film.setId(1);
        film.setName("Test name");
        film.setYearOfRelease(LocalDate.of(2025,1,1));
        film.setAgeRestriction(AgeRestrictionType.TEN_PLUS);
        film.setDuration(120);
        film.setSessions(List.of());

        FilmFullDto expected=new FilmFullDto();
        expected.setId(1);
        expected.setName("Test name");
        expected.setYearOfRelease(LocalDate.of(2025,1,1));
        expected.setAgeRestrictionType(AgeRestrictionType.TEN_PLUS);
        expected.setDuration(120);
        expected.setSessions(List.of());

        FilmFullDto actual = target.convertToFullDto(film);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertToDto() {
        Film film=new Film();
        film.setId(1);
        film.setName("Test name");
        film.setYearOfRelease(LocalDate.of(2025,1,1));
        film.setAgeRestriction(AgeRestrictionType.TEN_PLUS);
        film.setDuration(120);
        film.setSessions(List.of());

        FilmDto expected=new FilmDto(1,"Test name",LocalDate.of(2025,1,1));

        FilmDto actual = target.convertToDto(film);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertToEntity() {
        CreateFilmDto createFilmDto=new CreateFilmDto();
        createFilmDto.setId(100);
        createFilmDto.setName("Test name");
        createFilmDto.setYearOfRelease(LocalDate.of(2025,1,1));
        createFilmDto.setAgeRestrictionTypeDto(AgeRestrictionTypeDto.TEN_PLUS);
        createFilmDto.setDuration(120);

        Film expected=new Film("Test name",LocalDate.of(2025,1,1),AgeRestrictionType.TEN_PLUS,120);

        Film actual = target.convertToEntity(createFilmDto);

        assertThat(actual).isEqualTo(expected);
    }
}