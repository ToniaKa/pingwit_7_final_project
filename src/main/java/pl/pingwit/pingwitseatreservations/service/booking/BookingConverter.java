package pl.pingwit.pingwitseatreservations.service.booking;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingFullDto;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.CreateReservedSeatDto;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.place.Place;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeat;
import pl.pingwit.pingwitseatreservations.repository.session.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BookingConverter {

    public BookingDto convertToDto(Booking booking){
        BookingDto bookingDto=new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setClient(booking.getClient().getName());
        bookingDto.setTimeOfPurchase(booking.getTimeOfPurchase());


        bookingDto.setReservedSeats(new ArrayList<>());

            return bookingDto;


    }
    public Booking convertToEntity(CreateBookingDto createBookingDto){
        Client client=new Client();
        client.setId(createBookingDto.getClient());

        Booking booking=new Booking();
        booking.setClient(client);
        booking.setTimeOfPurchase(createBookingDto.getTimeOfPurchase());

        Session session = createBookingDto.getReservedSeats().stream()
                .map(CreateReservedSeatDto::getSessionId)
                .findFirst()
                .map(Session::new)
                .orElseThrow();

        List<ReservedSeat> reservedSeats = createBookingDto.getReservedSeats().stream()
                .map(reservedSeatDto -> {
                    Place place = new Place(reservedSeatDto.getPlaceId());
                    return new ReservedSeat(booking, session, place);

                }).toList();

        booking.setReservedSeats(reservedSeats);


        return booking;
    }
    public BookingFullDto convertToFullDto (Booking booking){
        BookingFullDto result=new BookingFullDto();
        result.setId(booking.getId());
        result.setClient(booking.getClient().getName());
        result.setTimeOfPurchase(booking.getTimeOfPurchase());


        result.setReservedSeats(new ArrayList<>());

        return result;
    }
}
