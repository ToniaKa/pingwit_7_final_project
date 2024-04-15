package pl.pingwit.pingwitseatreservations.controller.session;

import java.time.LocalDateTime;

public class UpdateSessionInputDto {
    private LocalDateTime startDateAndTime;
    private LocalDateTime endDateAndTime;
    private Integer film;

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
