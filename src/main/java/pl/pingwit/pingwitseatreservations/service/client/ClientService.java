package pl.pingwit.pingwitseatreservations.service.client;

import pl.pingwit.pingwitseatreservations.controller.client.ClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.ClientFullDto;
import pl.pingwit.pingwitseatreservations.controller.client.CreateClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.UpdateClientInputDto;
import pl.pingwit.pingwitseatreservations.controller.film.CreateFilmDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> listClients();
    ClientFullDto getClient(Integer id);
    Integer createClient(CreateClientDto clientDto);
    void updateClient(Integer id,UpdateClientInputDto inputDto);
}
