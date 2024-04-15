package pl.pingwit.pingwitseatreservations.controller.client;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;
import pl.pingwit.pingwitseatreservations.service.booking.BookingService;
import pl.pingwit.pingwitseatreservations.service.client.ClientService;

import java.util.List;

@Tag(name = "Client API")
@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final BookingService bookingService;

    public ClientController(ClientService clientService, BookingService bookingService) {
        this.clientService = clientService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<ClientDto> listClients() {
        return clientService.listClients();
    }

    @GetMapping("/{id}")
    public ClientFullDto getClient(@PathVariable(name = "id") Integer id) {
        return clientService.getClient(id);
    }

    @PostMapping
    public Integer createClient(@RequestBody CreateClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @PutMapping("/{id}")
    public void updateClient(@RequestBody UpdateClientInputDto inputDto, @PathVariable(name = "id") Integer id) {
        clientService.updateClient(id, inputDto);
    }

    @GetMapping("/{clientId}/booking") // здесь работаем с айдишкой клиента
    public BookingDto getBooking(@PathVariable(name = "clientId") Integer clientId) {
        // этот метод должен возвращать List<BookingDto> и называться как-то
        // getClientBookings
        // в bookingService нужно создать метод, который вернет список пронирований по айди клиента
        // это можно сделать, написав в репозитории метод findAllByClientId
        return bookingService.getBooking(id);
    }
}
