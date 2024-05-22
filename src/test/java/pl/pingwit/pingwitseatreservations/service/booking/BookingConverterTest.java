package pl.pingwit.pingwitseatreservations.service.booking;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateBookingDto;

import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateReservedSeatDto;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.client.ClientRepository;

import pl.pingwit.pingwitseatreservations.repository.place.Place;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeat;
import pl.pingwit.pingwitseatreservations.repository.session.Session;
import pl.pingwit.pingwitseatreservations.repository.session.SessionRepository;
import pl.pingwit.pingwitseatreservations.service.place.PlaceConverter;
import pl.pingwit.pingwitseatreservations.service.session.SessionConverter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class BookingConverterTest {
    private final PlaceConverter placeConverter = mock(PlaceConverter.class);
    private final ClientRepository clientRepository = mock(ClientRepository.class);
    private final SessionRepository sessionRepository = mock(SessionRepository.class);
    private final SessionConverter sessionConverter = mock(SessionConverter.class);

    private final BookingConverter target = new BookingConverter(placeConverter, clientRepository, sessionRepository, sessionConverter);

    @Test
    void shouldConvertToDto() {
        Booking booking = new Booking();
        booking.setId(1);
        booking.setClient(new Client("Test name", "Test surname", "Test email", "Test phone"));
        booking.setTimeOfPurchase(LocalDateTime.of(2025, 1, 1, 14, 0));
        booking.setReservedSeats(List.of());

        BookingDto expected = new BookingDto();
        expected.setId(1);
        expected.setClient("Test name");
        expected.setTimeOfPurchase(LocalDateTime.of(2025, 1, 1, 14, 0));
        expected.setReservedSeats(List.of());

        BookingDto actual = target.convertToDto(booking);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertToEntity() {
        CreateBookingDto createBookingDto = new CreateBookingDto();
        createBookingDto.setId(1);
        createBookingDto.setClient(1);
        createBookingDto.setTimeOfPurchase(LocalDateTime.of(2025, 1, 1, 14, 0));
        // здесь нужно передать хотя бы зарезервированное одно место. если его не передать - из строки 69 конвертера вылетит эксепшен
        createBookingDto.setReservedSeats(List.of(new CreateReservedSeatDto(1, 1)));

        Booking expected = new Booking();
        expected.setTimeOfPurchase(LocalDateTime.of(2025, 1, 1, 14, 0));


        Client client = new Client(1);
        expected.setClient(client);
        client.setBooking(List.of(expected));
        expected.setReservedSeats(List.of());

        // нужно дополнить expected необходимыми данными
        Session session = new Session();
        session.setId(1);

        Place place = new Place();
        place.setId(1);

        ReservedSeat reservedSeat = new ReservedSeat(expected, session, place);
        expected.setReservedSeats(List.of(reservedSeat));

        // нужно, чтобы мок возвращал клиента по айди:
        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        when(sessionRepository.findById(1)).thenReturn(Optional.of(session));


        Booking actual = target.convertToEntity(createBookingDto);

        assertThat(actual).isEqualTo(expected);
    }
}