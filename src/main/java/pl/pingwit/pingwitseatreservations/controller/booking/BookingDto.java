package pl.pingwit.pingwitseatreservations.controller.booking;
import pl.pingwit.pingwitseatreservations.repository.client.Client;

import java.time.LocalDateTime;

public class BookingDto {
    private Integer id;
    private String client;
    private LocalDateTime timeOfPurchase;

    public BookingDto() {



    }

    public BookingDto(Integer id, String client, LocalDateTime timeOfPurchase) {
        this.id = id;
        this.client = client;
        this.timeOfPurchase = timeOfPurchase;
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
}
