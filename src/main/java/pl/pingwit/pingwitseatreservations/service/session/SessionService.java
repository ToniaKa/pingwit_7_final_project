package pl.pingwit.pingwitseatreservations.service.session;

import pl.pingwit.pingwitseatreservations.controller.session.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.UpdateSessionInputDto;

import java.util.List;

public interface SessionService {
    List<SessionDto> listSessions();
    SessionDto getSession(Integer id);
    Integer createSession(CreateSessionDto createSessionDto);
    void updateSession(Integer id, UpdateSessionInputDto inputDto);
}
