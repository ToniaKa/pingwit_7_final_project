package pl.pingwit.pingwitseatreservations.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.pingwitseatreservations.repository.client.Client;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Optional<Booking> findAllByClient(Client client);
}
