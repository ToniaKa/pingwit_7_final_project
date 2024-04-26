package pl.pingwit.pingwitseatreservations.controller.place;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitseatreservations.controller.place.dto.CreatePlaceDto;
import pl.pingwit.pingwitseatreservations.controller.place.dto.PlaceDto;
import pl.pingwit.pingwitseatreservations.service.place.PlaceService;

import java.util.List;

@Tag(name = "Place API")
@RestController
@RequestMapping("/place")
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<PlaceDto> listPlaces() {
        return placeService.listPlaces();
    }

    @PostMapping
    public Integer createPlace(@RequestBody CreatePlaceDto placeDto) {
        return placeService.createPlace(placeDto);
    }
}
