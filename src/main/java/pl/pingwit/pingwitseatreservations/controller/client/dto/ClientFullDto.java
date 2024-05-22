package pl.pingwit.pingwitseatreservations.controller.client.dto;

import pl.pingwit.pingwitseatreservations.controller.booking.dto.BookingDto;

import java.util.List;
import java.util.Objects;

public class ClientFullDto {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<BookingDto> booking;


    public List<BookingDto> getBooking() {
        return booking;
    }

    public void setBooking(List<BookingDto> booking) {
        this.booking = booking;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientFullDto that = (ClientFullDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(booking, that.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, phone, booking);
    }
}
