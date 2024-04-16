package pl.pingwit.pingwitseatreservations.repository.booking;

import jakarta.persistence.*;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.film.Film;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking",schema = "seat_reservations")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_gen")
    @SequenceGenerator(name = "booking_id_gen", sequenceName = "booking_id_seq",schema = "seat_reservations", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
    @Column(name = "time_of_purchase")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeOfPurchase;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(LocalDateTime timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }
}
