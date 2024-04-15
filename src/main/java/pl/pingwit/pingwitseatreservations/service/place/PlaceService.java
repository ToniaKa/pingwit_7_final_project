package pl.pingwit.pingwitseatreservations.service.place;

import pl.pingwit.pingwitseatreservations.controller.place.CreatePlaceDto;
import pl.pingwit.pingwitseatreservations.controller.place.PlaceDto;

import java.util.List;

public interface PlaceService {
    List<PlaceDto> listPlaces();
    Integer createPlace (CreatePlaceDto placeDto);
}
