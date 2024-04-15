package pl.pingwit.pingwitseatreservations.service.booking;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.client.Client;

@Component
public class BookingConverter {
    public BookingDto convertToDto(Booking booking){
        BookingDto bookingDto=new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setClient(booking.getClientId().getName());
        bookingDto.setTimeOfPurchase(booking.getTimeOfPurchase());
        return bookingDto;
    }
}
