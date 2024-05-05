package pl.pingwit.pingwitseatreservations.controller.booking.dto;

import pl.pingwit.pingwitseatreservations.controller.place.dto.PlaceDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionDto;

import java.util.Objects;

public class ReservedSeatDto {

    private Integer id;
    private SessionDto filmSession;
    private PlaceDto place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SessionDto getFilmSession() {
        return filmSession;
    }

    public void setFilmSession(SessionDto filmSession) {
        this.filmSession = filmSession;
    }

    public PlaceDto getPlace() {
        return place;
    }

    public void setPlace(PlaceDto place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedSeatDto that = (ReservedSeatDto) o;
        return Objects.equals(id, that.id) && Objects.equals(filmSession, that.filmSession) && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filmSession, place);
    }
}
