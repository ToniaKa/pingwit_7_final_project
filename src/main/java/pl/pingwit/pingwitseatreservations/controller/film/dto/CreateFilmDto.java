package pl.pingwit.pingwitseatreservations.controller.film.dto;

import java.time.LocalDate;
import java.util.Objects;

public class CreateFilmDto {

    private Integer id;
    private String name;
    private LocalDate yearOfRelease;
    private AgeRestrictionTypeDto ageRestrictionTypeDto;
    private Integer duration;


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

    public AgeRestrictionTypeDto getAgeRestrictionTypeDto() {
        return ageRestrictionTypeDto;
    }

    public void setAgeRestrictionTypeDto(AgeRestrictionTypeDto ageRestrictionTypeDto) {
        this.ageRestrictionTypeDto = ageRestrictionTypeDto;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateFilmDto that = (CreateFilmDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(yearOfRelease, that.yearOfRelease) && ageRestrictionTypeDto == that.ageRestrictionTypeDto && Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, yearOfRelease, ageRestrictionTypeDto, duration);
    }
}
