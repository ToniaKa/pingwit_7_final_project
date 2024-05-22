package pl.pingwit.pingwitseatreservations.repository.place;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "place", schema = "seat_reservations")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_id_gen")
    @SequenceGenerator(name = "place_id_gen", sequenceName = "place_id_seq", schema = "seat_reservations", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Column(name = "row")
    private Integer row;
    @Column(name = "number")
    private Integer number;

    public Place() {
    }

    public Place(Integer id) {
        this.id = id;
    }

    public Place(Integer row, Integer number) {
        this.row = row;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(id, place.id) && Objects.equals(row, place.row) && Objects.equals(number, place.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, number);
    }
}
