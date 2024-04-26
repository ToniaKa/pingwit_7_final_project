package pl.pingwit.pingwitseatreservations.repository.session;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
