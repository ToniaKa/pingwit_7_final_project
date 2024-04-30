package pl.pingwit.pingwitseatreservations.controller.film.dto;

import java.time.LocalDate;

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
}
