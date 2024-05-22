package pl.pingwit.pingwitseatreservations.repository.booking;

import jakarta.persistence.*;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "booking", schema = "seat_reservations")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_gen")
    @SequenceGenerator(name = "booking_id_gen", sequenceName = "booking_id_seq", schema = "seat_reservations", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "time_of_purchase")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeOfPurchase;

    @OneToMany(mappedBy = "booking", cascade = ALL)
    private List<ReservedSeat> reservedSeats;

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

    public List<ReservedSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) && Objects.equals(client, booking.client) && Objects.equals(timeOfPurchase, booking.timeOfPurchase) && Objects.equals(reservedSeats, booking.reservedSeats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, timeOfPurchase, reservedSeats);
    }
}
