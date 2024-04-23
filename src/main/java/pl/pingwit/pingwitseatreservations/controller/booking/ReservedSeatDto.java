package pl.pingwit.pingwitseatreservations.controller.booking;

import pl.pingwit.pingwitseatreservations.controller.place.PlaceDto;
import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;

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


}
