package pl.pingwit.pingwitseatreservations.controller.place;

import java.util.Objects;

public class PlaceDto {
    private Integer id;
    private Integer row;
    private Integer number;

    public PlaceDto(Integer id, Integer row, Integer number) {
        this.id = id;
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
        PlaceDto placeDto = (PlaceDto) o;
        return Objects.equals(id, placeDto.id) && Objects.equals(row, placeDto.row) && Objects.equals(number, placeDto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, row, number);
    }
}
