package pl.pingwit.pingwitseatreservations.controller.film.dto;

import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionShortDto;
import pl.pingwit.pingwitseatreservations.repository.film.AgeRestrictionType;

import java.time.LocalDate;
import java.util.List;

public class FilmFullDto {

    private Integer id;
    private String name;
    private LocalDate yearOfRelease;
    private AgeRestrictionType ageRestrictionType;
    private Integer duration;
    private List<SessionShortDto> sessions;


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

    public AgeRestrictionType getAgeRestrictionType() {
        return ageRestrictionType;
    }

    public void setAgeRestrictionType(AgeRestrictionType ageRestrictionType) {
        this.ageRestrictionType = ageRestrictionType;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<SessionShortDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionShortDto> sessions) {
        this.sessions = sessions;
    }
}
