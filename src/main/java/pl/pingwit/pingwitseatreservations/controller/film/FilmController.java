package pl.pingwit.pingwitseatreservations.controller.film;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitseatreservations.service.film.FilmService;

import java.util.List;
@Tag(name = "Film API")
@RestController
@RequestMapping("/film")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<FilmDto> listFilms(){
        return filmService.listFilms();
    }

    @GetMapping("/{id}")
    public FilmFullDto getFilm(@PathVariable (name = "id") Integer id){return filmService.getFilm(id);}
    @PostMapping
    public Integer createFilm(@RequestBody CreateFilmDto filmDto){return filmService.createFilm(filmDto);}
    @PutMapping("/{id}")
    public void updateFilm(@RequestBody UpdateFilmInputDto inputDto,@PathVariable(name = "id") Integer id){filmService.updateFilm(id,inputDto);}
}
