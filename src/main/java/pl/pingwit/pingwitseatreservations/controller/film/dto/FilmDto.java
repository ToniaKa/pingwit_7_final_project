package pl.pingwit.pingwitseatreservations.controller.film.dto;

import java.time.LocalDate;

public class FilmDto {
    private Integer id;
    private String name;
    private LocalDate yearOfRelease;

    public FilmDto(Integer id, String name, LocalDate yearOfRelease) {
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
}
