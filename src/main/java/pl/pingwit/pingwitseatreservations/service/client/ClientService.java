package pl.pingwit.pingwitseatreservations.service.client;

import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientFullDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.CreateClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.UpdateClientDto;

import java.util.List;

public interface ClientService {

    List<ClientDto> listClients();

    ClientFullDto getClient(Integer id);

    Integer createClient(CreateClientDto clientDto);

    void updateClient(Integer id, UpdateClientDto inputDto);
}
