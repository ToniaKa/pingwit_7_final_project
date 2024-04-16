package pl.pingwit.pingwitseatreservations.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
   Optional<Booking> findAllByClientId(Integer clientId);
}
