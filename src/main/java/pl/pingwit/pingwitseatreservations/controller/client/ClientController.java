package pl.pingwit.pingwitseatreservations.controller.client;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientFullDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.CreateClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.UpdateClientDto;
import pl.pingwit.pingwitseatreservations.service.booking.BookingService;
import pl.pingwit.pingwitseatreservations.service.client.ClientService;
import pl.pingwit.pingwitseatreservations.service.export.ClientExportService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Client API")
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    private final BookingService bookingService;
    private final ClientExportService clientExportService;

    public ClientController(ClientService clientService, BookingService bookingService, ClientExportService clientExportService) {
        this.clientService = clientService;
        this.bookingService = bookingService;
        this.clientExportService = clientExportService;
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
    public void updateClient(@RequestBody UpdateClientDto inputDto, @PathVariable(name = "id") Integer id) {
        clientService.updateClient(id, inputDto);
    }

    @GetMapping("/{clientId}/booking")
    public List<BookingDto> getClientBookings(@PathVariable(name = "clientId") Integer clientId) {
        return bookingService.getClientBookings(clientId);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportBookingsToExcel() {
        try {
            byte[] fileBytes = clientExportService.exportClients();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "clients.xlsx");

            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
