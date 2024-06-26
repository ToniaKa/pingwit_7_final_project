package pl.pingwit.pingwitseatreservations.controller.session.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class SessionDto {

    private Integer id;
    private LocalDateTime startDateAndTime;
    private LocalDateTime endDateAndTime;
    private String film;


    public SessionDto() {
    }

    public SessionDto(Integer id, LocalDateTime startDateAndTime, LocalDateTime endDateAndTime, String film) {
        this.id = id;
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
        this.film = film;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(LocalDateTime startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public LocalDateTime getEndDateAndTime() {
        return endDateAndTime;
    }

    public void setEndDateAndTime(LocalDateTime endDateAndTime) {
        this.endDateAndTime = endDateAndTime;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionDto that = (SessionDto) o;
        return Objects.equals(id, that.id) && Objects.equals(startDateAndTime, that.startDateAndTime) && Objects.equals(endDateAndTime, that.endDateAndTime) && Objects.equals(film, that.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDateAndTime, endDateAndTime, film);
    }
}
