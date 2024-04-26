package pl.pingwit.pingwitseatreservations.service.place;

import pl.pingwit.pingwitseatreservations.controller.place.dto.CreatePlaceDto;
import pl.pingwit.pingwitseatreservations.controller.place.dto.PlaceDto;

import java.util.List;

public interface PlaceService {
    List<PlaceDto> listPlaces();

    Integer createPlace(CreatePlaceDto placeDto);
}
