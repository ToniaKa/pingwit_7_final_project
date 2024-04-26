package pl.pingwit.pingwitseatreservations.repository.reservedSeats;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservedSeatsRepository extends JpaRepository<ReservedSeat, Integer> {

    List<ReservedSeat> findAllBySessionIdAndPlaceId(Integer sessionId, Integer placeId);

}
