package pl.pingwit.pingwitseatreservations.controller.session;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitseatreservations.controller.session.dto.CreateSessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.SessionDto;
import pl.pingwit.pingwitseatreservations.controller.session.dto.UpdateSessionInputDto;
import pl.pingwit.pingwitseatreservations.service.session.SessionService;

import java.util.List;

@Tag(name = "Session API")
@RestController
@RequestMapping("/session")
public class SessionController {
    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping
    public List<SessionDto> listSessions() {
        return sessionService.listSessions();
    }

    @GetMapping("/{id}")
    public SessionDto getSession(@PathVariable(name = "id") Integer id) {
        return sessionService.getSession(id);
    }

    @PostMapping
    public Integer createSession(@RequestBody CreateSessionDto sessionDto) {
        return sessionService.createSession(sessionDto);
    }

    @PutMapping("/{id}")
    public void updateSession(@RequestBody UpdateSessionInputDto inputDto, @PathVariable(name = "id") Integer id) {
        sessionService.updateSession(id, inputDto);
    }
}
