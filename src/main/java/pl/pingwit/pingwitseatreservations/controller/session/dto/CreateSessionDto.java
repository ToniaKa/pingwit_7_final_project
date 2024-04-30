package pl.pingwit.pingwitseatreservations.controller.session.dto;

import java.time.LocalDateTime;

public class CreateSessionDto {
    // отделяй плиз поля пустой строкой

    private LocalDateTime startDateAndTime;
    private Integer film;


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

}
