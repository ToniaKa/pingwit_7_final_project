package pl.pingwit.pingwitseatreservations.service.client;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientFullDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.CreateClientDto;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.service.booking.BookingConverter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ClientConverterTest {
    private final BookingConverter bookingConverter=mock(BookingConverter.class);

    private final ClientConverter target=new ClientConverter(bookingConverter);

    @Test
    void shouldConvertToDto() {
        Client client=new Client();
        client.setId(1);
        client.setName("Test name");
        client.setSurname("Test surname");
        client.setEmail("Test email");
        client.setPhone("Test phone");
        client.setBooking(List.of());

        ClientDto expected=new ClientDto(1,"Test name","Test surname");

        ClientDto actual = target.convertToDto(client);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertToFullDto() {
        Client client=new Client();
        client.setId(1);
        client.setName("Test name");
        client.setSurname("Test surname");
        client.setEmail("Test email");
        client.setPhone("Test phone");
        client.setBooking(List.of());

        ClientFullDto expected=new ClientFullDto();
        expected.setId(1);
        expected.setName("Test name");
        expected.setSurname("Test surname");
        expected.setEmail("Test email");
        expected.setPhone("Test phone");
        expected.setBooking(List.of());

        ClientFullDto actual = target.convertToFullDto(client);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldConvertToEntity() {
        CreateClientDto createClientDto=new CreateClientDto();
        createClientDto.setId(1);
        createClientDto.setName("Test name");
        createClientDto.setSurname("Test surname");
        createClientDto.setEmail("Test email");
        createClientDto.setPhone("Test phone");

        Client expected=new Client();
        expected.setName("Test name");
        expected.setSurname("Test surname");
        expected.setEmail("Test email");
        expected.setPhone("Test phone");

        Client actual = target.convertToEntity(createClientDto);

        assertThat(actual).isEqualTo(expected);
    }
}