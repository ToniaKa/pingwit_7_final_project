package pl.pingwit.pingwitseatreservations.repository.reservedSeats;

import jakarta.persistence.*;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.place.Place;
import pl.pingwit.pingwitseatreservations.repository.session.Session;

import java.util.Objects;

@Entity
@Table(name = "reserved_seats", schema = "seat_reservations")
public class ReservedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserved_seats_id_gen")
    @SequenceGenerator(name = "reserved_seats_id_gen", sequenceName = "reserved_seats_seq", schema = "seat_reservations", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    public ReservedSeat() {
    }

    public ReservedSeat(Booking bookingId, Session sessionId, Place placeId) {
        this.booking = bookingId;
        this.session = sessionId;
        this.place = placeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedSeat that = (ReservedSeat) o;
        return Objects.equals(id, that.id) && Objects.equals(booking, that.booking) && Objects.equals(session, that.session) && Objects.equals(place, that.place);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, booking, session, place);
    }
}
