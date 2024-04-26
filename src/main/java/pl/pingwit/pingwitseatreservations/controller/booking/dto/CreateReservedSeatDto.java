package pl.pingwit.pingwitseatreservations.controller.booking.dto;

public class CreateReservedSeatDto {
    private Integer sessionId;
    private Integer placeId;


    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

}
