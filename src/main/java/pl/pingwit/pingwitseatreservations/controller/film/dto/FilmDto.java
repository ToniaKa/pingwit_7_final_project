package pl.pingwit.pingwitseatreservations.controller.film.dto;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmDto filmDto = (FilmDto) o;
        return Objects.equals(id, filmDto.id) && Objects.equals(name, filmDto.name) && Objects.equals(yearOfRelease, filmDto.yearOfRelease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, yearOfRelease);
    }
}
