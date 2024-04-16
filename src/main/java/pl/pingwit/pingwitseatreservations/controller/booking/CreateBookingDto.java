package pl.pingwit.pingwitseatreservations.controller.booking;
import java.time.LocalDateTime;

public class CreateBookingDto {
    private Integer client;
    private LocalDateTime timeOfPurchase;

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
}
