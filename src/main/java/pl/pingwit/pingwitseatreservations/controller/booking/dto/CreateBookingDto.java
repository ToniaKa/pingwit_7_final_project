package pl.pingwit.pingwitseatreservations.controller.booking.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CreateBookingDto {

    private Integer id;

    private Integer client;
    private LocalDateTime timeOfPurchase;
    private List<CreateReservedSeatDto> reservedSeats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateBookingDto that = (CreateBookingDto) o;
        return Objects.equals(client, that.client) && Objects.equals(timeOfPurchase, that.timeOfPurchase) && Objects.equals(reservedSeats, that.reservedSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, timeOfPurchase, reservedSeats);
    }
}
