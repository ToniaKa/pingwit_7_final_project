package pl.pingwit.pingwitseatreservations.service.session;

import pl.pingwit.pingwitseatreservations.controller.session.dto.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.UpdateSessionDto;

import java.util.List;

public interface SessionService {

    List<SessionDto> listSessions();

    SessionDto getSession(Integer id);

    Integer createSession(CreateSessionDto createSessionDto);

    void updateSession(Integer id, UpdateSessionDto inputDto);
}
