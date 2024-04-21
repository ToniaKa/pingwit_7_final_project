package pl.pingwit.pingwitseatreservations.controller.booking;

import pl.pingwit.pingwitseatreservations.controller.place.PlaceDto;
import pl.pingwit.pingwitseatreservations.service.place.PlaceConverter;

public class ReservedSeatDto {

    private Integer id;
    private Integer sessionId;
    private PlaceDto place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlaceDto getPlace() {
        return place;
    }

    public void setPlace(PlaceDto place) {
        this.place = place;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }
}
