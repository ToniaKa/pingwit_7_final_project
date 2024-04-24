package pl.pingwit.pingwitseatreservations.repository.reservedSeats;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservedSeatsRepository extends JpaRepository<ReservedSeat,Integer> {
}
