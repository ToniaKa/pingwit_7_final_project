package pl.pingwit.pingwitseatreservations.controller.session.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreateSessionDto {


    private Integer id;
    private LocalDateTime startDateAndTime;
    private Integer film;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilm() {
        return film;
    }

    public void setFilm(Integer film) {
        this.film = film;
    }

    public LocalDateTime getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(LocalDateTime startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateSessionDto that = (CreateSessionDto) o;
        return Objects.equals(startDateAndTime, that.startDateAndTime) && Objects.equals(film, that.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDateAndTime, film);
    }
}
