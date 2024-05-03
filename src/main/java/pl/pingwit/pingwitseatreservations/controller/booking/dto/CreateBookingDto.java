package pl.pingwit.pingwitseatreservations.controller.booking.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CreateBookingDto {

    private Integer client;
    private LocalDateTime timeOfPurchase;
    private List<CreateReservedSeatDto> reservedSeats;

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public LocalDateTime getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(LocalDateTime timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }

    public List<CreateReservedSeatDto> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<CreateReservedSeatDto> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
