package pl.pingwit.pingwitseatreservations.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.pingwitseatreservations.controller.booking.BookingDto;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

}
