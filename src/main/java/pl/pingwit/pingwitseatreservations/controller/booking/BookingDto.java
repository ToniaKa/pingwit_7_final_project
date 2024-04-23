package pl.pingwit.pingwitseatreservations.controller.booking;
import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeat;

import java.time.LocalDateTime;
import java.util.List;

public class BookingDto {
    private Integer id;
    private String client;
    private LocalDateTime timeOfPurchase;
    private List<ReservedSeatDto> reservedSeats;


    public BookingDto() {
    }

    public BookingDto(Integer id, String client, LocalDateTime timeOfPurchase, List<ReservedSeatDto> reservedSeats) {
        this.id = id;
        this.client = client;
        this.timeOfPurchase = timeOfPurchase;
        this.reservedSeats = reservedSeats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(LocalDateTime timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }

    public List<ReservedSeatDto> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeatDto> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

}
