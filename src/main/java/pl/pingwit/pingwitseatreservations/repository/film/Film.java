package pl.pingwit.pingwitseatreservations.repository.film;

import jakarta.persistence.*;
import pl.pingwit.pingwitseatreservations.repository.session.Session;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "film", schema = "seat_reservations")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_id_gen")
    @SequenceGenerator(name = "film_id_gen", sequenceName = "film_id_seq", schema = "seat_reservations", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_release")
    private LocalDate yearOfRelease;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "age_restriction")
    private AgeRestrictionType ageRestriction;

    @Column(name = "duration")
    private Integer duration;

    @OneToMany(mappedBy = "film")
    private List<Session> sessions;

    public Film() {
    }

    // если этот конструктор не понадобится в тестах - удаляй его. аналогично для всех сущностей и dto
    public Film(String name, LocalDate yearOfRelease, AgeRestrictionType ageRestriction, Integer duration) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.ageRestriction = ageRestriction;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(LocalDate yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public AgeRestrictionType getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestrictionType ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
