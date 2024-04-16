package pl.pingwit.pingwitseatreservations.controller.film;

import pl.pingwit.pingwitseatreservations.repository.film.AgeRestrictionType;

import java.time.LocalDate;

public class CreateFilmDto {
    private Integer id;
    private Integer name;
    private LocalDate yearOfRelease;
    private AgeRestrictionTypeDto ageRestrictionTypeDto;
    private Integer duration;

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
}
