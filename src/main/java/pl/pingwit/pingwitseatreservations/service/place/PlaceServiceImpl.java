package pl.pingwit.pingwitseatreservations.service.place;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.controller.place.CreatePlaceDto;
import pl.pingwit.pingwitseatreservations.controller.place.PlaceDto;
import pl.pingwit.pingwitseatreservations.repository.place.Place;
import pl.pingwit.pingwitseatreservations.repository.place.PlaceRepository;

import java.util.List;
@Transactional
@Service
public class PlaceServiceImpl implements PlaceService{
    private final PlaceRepository placeRepository;
    private final PlaceConverter placeConverter;

    public PlaceServiceImpl(PlaceRepository placeRepository, PlaceConverter placeConverter) {
        this.placeRepository = placeRepository;
        this.placeConverter = placeConverter;
    }

    @Override
    public List<PlaceDto> listPlaces() {
        return placeRepository.findAll().stream()
                .map(placeConverter::convertToDto)
                .toList();
    }

    @Override
    public Integer createPlace(CreatePlaceDto placeDto) {
        Place savedPlace = placeRepository.save(placeConverter.convertToEntity(placeDto));
        return savedPlace.getId();
    }
}
