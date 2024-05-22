package pl.pingwit.pingwitseatreservations.validator;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitseatreservations.controller.client.dto.CreateClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.UpdateClientDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationsValidationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ClientValidatorTest {
    
    private final ClientValidator target=new ClientValidator();

    @Test
    void shouldCreateClient() {
        CreateClientDto createClientDto=new CreateClientDto();
        createClientDto.setName("Test name");
        createClientDto.setSurname("Test surname");
        createClientDto.setEmail("gg@gmail.com");
        createClientDto.setPhone("1253");

        CreateClientDto expected =new CreateClientDto();
        expected.setName("Test name");
        expected.setSurname("Test surname");
        expected.setEmail("gg@gmail.com");
        expected.setPhone("1253");

        target.validateOnCreate(createClientDto);
        assertThat(createClientDto).isEqualTo(expected);
    }

    @Test
    void shouldReturnExceptionsWhenCreateClient() {
        CreateClientDto createClientDto=new CreateClientDto();
        createClientDto.setName("");
        createClientDto.setSurname("");
        createClientDto.setEmail("gggmailcom");
        createClientDto.setPhone("1253test");

        assertThrows(SeatReservationsValidationException.class,
                ()->target.validateOnCreate(createClientDto));
    }

    @Test
    void shouldReturnExceptionsWhenUpdateClient() {
        UpdateClientDto updateClientDto=new UpdateClientDto();
        updateClientDto.setName("");
        updateClientDto.setSurname("");
        updateClientDto.setEmail("gggmailcom");
        updateClientDto.setPhone("1253test");

        assertThrows(SeatReservationsValidationException.class,
                ()->target.validateOnUpdate(updateClientDto));
    }
}