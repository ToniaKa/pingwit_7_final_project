package pl.pingwit.pingwitseatreservations.controller.place;

import jakarta.persistence.Column;

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
}
