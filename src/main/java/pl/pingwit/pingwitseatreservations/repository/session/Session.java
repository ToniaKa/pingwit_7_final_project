package pl.pingwit.pingwitseatreservations.repository.session;

import jakarta.persistence.*;
import pl.pingwit.pingwitseatreservations.repository.film.Film;

import java.time.LocalDateTime;

@Entity
@Table(name = "session",schema = "seat_reservations")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_id_gen")
    @SequenceGenerator(name = "session_id_gen", sequenceName = "session_id_seq",schema = "seat_reservations", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_date_and_time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDateAndTime;
    @Column(name = "end_date_and_time")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDateAndTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;

    public Session() {
    }

    public Session(LocalDateTime startDateAndTime, LocalDateTime endDateAndTime) {
        this.startDateAndTime = startDateAndTime;
        this.endDateAndTime = endDateAndTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartDateAndTime() {
        return startDateAndTime;
    }

    public void setStartDateAndTime(LocalDateTime startDateAndTime) {
        this.startDateAndTime = startDateAndTime;
    }

    public LocalDateTime getEndDateAndTime() {
        return endDateAndTime;
    }

    public void setEndDateAndTime(LocalDateTime endDateAndTime) {
        this.endDateAndTime = endDateAndTime;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
