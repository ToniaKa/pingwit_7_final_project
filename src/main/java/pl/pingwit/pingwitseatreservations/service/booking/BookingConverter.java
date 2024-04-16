package pl.pingwit.pingwitseatreservations.service.booking;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingFullDto;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.film.Film;

@Component
public class BookingConverter {
    public BookingDto convertToDto(Booking booking){
        BookingDto bookingDto=new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setClient(booking.getClient().getName());
        bookingDto.setTimeOfPurchase(booking.getTimeOfPurchase());
        return bookingDto;
    }
    public Booking createBooking (CreateBookingDto createBookingDto){
        Client client=new Client();
        client.setId(createBookingDto.getClient());

        Booking entity=new Booking();
        entity.setClient(client);
        entity.setTimeOfPurchase(createBookingDto.getTimeOfPurchase());
        return entity;
    }
    public BookingFullDto convertToFullDto (Booking booking){
        BookingFullDto result=new BookingFullDto();
        result.setId(booking.getId());
        result.setClient(booking.getClient().getName());
        result.setTimeOfPurchase(booking.getTimeOfPurchase());
        return result;
    }
}
