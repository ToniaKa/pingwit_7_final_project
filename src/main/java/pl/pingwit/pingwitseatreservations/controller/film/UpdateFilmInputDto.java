package pl.pingwit.pingwitseatreservations.controller.film;

import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;
import pl.pingwit.pingwitseatreservations.repository.film.AgeRestrictionType;

import java.time.LocalDate;
import java.util.List;

public class UpdateFilmInputDto {

    private Integer name;
    private LocalDate yearOfRelease;
    private AgeRestrictionType ageRestrictionType;
    private Integer duration;
    private List<SessionDto> sessions;


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

    public List<SessionDto> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDto> sessions) {
        this.sessions = sessions;
    }
}
