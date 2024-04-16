package pl.pingwit.pingwitseatreservations.controller.session;

import java.time.LocalDateTime;

public class SessionDto {
    private Integer id;
    private LocalDateTime startDateAndTime;
    private LocalDateTime endDateAndTime;
    private Integer film;

    public SessionDto() {
    }

    public SessionDto(Integer id, LocalDateTime startDateAndTime, LocalDateTime endDateAndTime, Integer film) {
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

    public Integer getFilm() {
        return film;
    }

    public void setFilm(Integer film) {
        this.film = film;
    }
}
