package pl.pingwit.pingwitseatreservations.service.client;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.client.ClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.ClientFullDto;
import pl.pingwit.pingwitseatreservations.controller.client.CreateClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.UpdateClientInputDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservNotFoundException;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.client.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    public ClientServiceImpl(ClientRepository clientRepository, ClientConverter clientConverter) {
        this.clientRepository = clientRepository;
        this.clientConverter = clientConverter;
    }

    @Override
    public List<ClientDto> listClients() {
        return clientRepository.findAll().stream()
                .map(clientConverter::convertToDto)
                .toList();
    }
    @Override
    public ClientFullDto getClient(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(()-> new SeatReservNotFoundException("Client with id not found " + id));
        return clientConverter.convertToFullDto(client);
    }

    @Override
    public Integer createClient(CreateClientDto clientDto) {
        Client savedClient = clientRepository.save(clientConverter.convertToEntity(clientDto));
        return savedClient.getId();
    }

    @Override
    public void updateClient(Integer id, UpdateClientInputDto inputDto) {
        Client clientToUpdate = clientRepository.findById(id).orElseThrow(()-> new SeatReservNotFoundException("Client with id not found " + id));
        clientToUpdate.setName(inputDto.getName());
        clientToUpdate.setSurname(inputDto.getSurname());
        clientToUpdate.setEmail(inputDto.getEmail());
        clientToUpdate.setPhone(inputDto.getPhone());
        clientRepository.save(clientToUpdate);
    }

}
