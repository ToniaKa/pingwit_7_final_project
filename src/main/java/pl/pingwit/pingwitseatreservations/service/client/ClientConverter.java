package pl.pingwit.pingwitseatreservations.service.client;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.client.ClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.ClientFullDto;
import pl.pingwit.pingwitseatreservations.controller.client.CreateClientDto;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.service.booking.BookingConverter;

@Component
public class ClientConverter {
    private final BookingConverter bookingConverter;

    public ClientConverter(BookingConverter bookingConverter) {
        this.bookingConverter = bookingConverter;
    }

    public ClientDto convertToDto (Client client){
        return new ClientDto(client.getId(),client.getName(),client.getSurname());
    }
    public ClientFullDto convertToFullDto(Client client){
        ClientFullDto result=new ClientFullDto();
        result.setId(client.getId());
        result.setName(client.getName());
        result.setSurname(client.getSurname());
        result.setEmail(client.getEmail());
        result.setPhone(client.getPhone());
        result.setBooking(client.getBooking().stream().map(bookingConverter::convertToDto).toList());
        return result;
    }
    public Client convertToEntity (CreateClientDto clientDto){
        return new Client(clientDto.getName(), clientDto.getSurname(), clientDto.getEmail(), clientDto.getPhone());
    }
}
