package pl.pingwit.pingwitseatreservations.controller.place.dto;

import java.util.Objects;

public class CreatePlaceDto {

    private Integer id;
    private Integer row;
    private Integer number;


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
        CreatePlaceDto that = (CreatePlaceDto) o;
        return Objects.equals(id, that.id) && Objects.equals(row, that.row) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, number);
    }
}
