package pl.pingwit.pingwitseatreservations.controller.film;

import java.time.LocalDate;

public class FilmDto {
    private Integer id;
    private Integer name;
    private LocalDate yearOfRelease;

    public FilmDto(Integer id, Integer name, LocalDate yearOfRelease) {
        this.id = id;
        this.name = name;
        this.yearOfRelease = yearOfRelease;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public LocalDate getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(LocalDate yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}
