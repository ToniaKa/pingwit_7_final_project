package pl.pingwit.pingwitseatreservations.service.place;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.place.CreatePlaceDto;
import pl.pingwit.pingwitseatreservations.controller.place.PlaceDto;
import pl.pingwit.pingwitseatreservations.repository.place.Place;

@Component
public class PlaceConverter {
    public PlaceDto convertToDto(Place place) {
        return new PlaceDto(place.getId(), place.getRow(), place.getNumber());
    }

    public Place convertToEntity(CreatePlaceDto placeDto) {
        return new Place(placeDto.getRow(), placeDto.getNumber());
    }
}
