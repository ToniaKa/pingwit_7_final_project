package pl.pingwit.pingwitseatreservations.controller.session.dto;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionShortDto that = (SessionShortDto) o;
        return Objects.equals(id, that.id) && Objects.equals(startDateAndTime, that.startDateAndTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDateAndTime);
    }
}
