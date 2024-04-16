package pl.pingwit.pingwitseatreservations.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pingwit.pingwitseatreservations.repository.client.Client;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
   List<Booking> findAllByClientId(Client client);
}
