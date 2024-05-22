package pl.pingwit.pingwitseatreservations.service.session;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitseatreservations.controller.session.dto.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionShortDto;
import pl.pingwit.pingwitseatreservations.repository.film.AgeRestrictionType;
import pl.pingwit.pingwitseatreservations.repository.film.Film;
import pl.pingwit.pingwitseatreservations.repository.session.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class SessionConverterTest {
    private final SessionConverter target=new SessionConverter();


    @Test
    void shouldConvertToDto() {
        //given
        Session session=new Session();
        session.setId(1);
        session.setStartDateAndTime(LocalDateTime.of(2025,1,1,19, 0));
        session.setEndDateAndTime(LocalDateTime.of(2025,1,1,21,0));
        session.setFilm(new Film("Test film", LocalDate.of(2024,1,1), AgeRestrictionType.TEN_PLUS,120));

        SessionDto expected=new SessionDto();
        expected.setId(1);
        expected.setStartDateAndTime(LocalDateTime.of(2025,1,1,19, 0));
        expected.setEndDateAndTime(LocalDateTime.of(2025,1,1,21,0));
        expected.setFilm("Test film");


        //when
        SessionDto actual = target.convertToDto(session);


        //than
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertToEntity() {
        //given

        CreateSessionDto createSessionDto=new CreateSessionDto();
        Film film =new Film();
        film.setId(100);
        createSessionDto.setId(100);
        createSessionDto.setStartDateAndTime((LocalDateTime.of(2025,1,1,19, 0)));
        createSessionDto.setFilm(100);

        Session expected =new Session();
        expected.setStartDateAndTime((LocalDateTime.of(2025,1,1,19, 0)));
        expected.setFilm(film);


        //when
        Session actual = target.convertToEntity(createSessionDto);

        //than
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertToShortDto() {
        Session session=new Session();
        session.setId(1);
        session.setStartDateAndTime(LocalDateTime.of(2025,1,1,19, 0));
        session.setEndDateAndTime(LocalDateTime.of(2025,1,1,21,0));
        session.setFilm(new Film("Test film", LocalDate.of(2024,1,1), AgeRestrictionType.TEN_PLUS,120));

        SessionShortDto expected =new SessionShortDto();
        expected.setId(1);
        expected.setStartDateAndTime(LocalDateTime.of(2025,1,1,19, 0));

        //when
        SessionShortDto actual = target.convertToShortDto(session);


        //than
        assertThat(actual).isEqualTo(expected);

    }
}