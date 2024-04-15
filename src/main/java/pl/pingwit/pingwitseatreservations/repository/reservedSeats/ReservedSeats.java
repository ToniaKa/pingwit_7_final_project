package pl.pingwit.pingwitseatreservations.repository.reservedSeats;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.place.Place;
import pl.pingwit.pingwitseatreservations.repository.session.Session;

@Entity
@Table(name = "reserved_seats",schema = "seat_reservations")
public class ReservedSeats {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserved_seats_id_gen")
    @SequenceGenerator(name = "reserved_seats_id_gen", sequenceName = "reserved_seats_id_seq",schema = "seat_reservations", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Booking bookingId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Session sessionId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Place placeId;

}
