package pl.pingwit.pingwitseatreservations.controller.session.dto;

import java.time.LocalDateTime;

public class SessionShortDto {

    private Integer id;
    private LocalDateTime startDateAndTime;


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
}
