package pl.pingwit.pingwitseatreservations.service.place;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitseatreservations.controller.place.dto.CreatePlaceDto;
import pl.pingwit.pingwitseatreservations.controller.place.dto.PlaceDto;
import pl.pingwit.pingwitseatreservations.repository.place.Place;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlaceConverterTest {
    private final PlaceConverter target=new PlaceConverter();

    @Test
    void shouldConvertToDto() {
        Place place=new Place();
        place.setId(1);
        place.setNumber(1);
        place.setRow(1);

        PlaceDto expected=new PlaceDto(1,1,1);

        PlaceDto actual = target.convertToDto(place);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void shouldConvertToEntity() {
        CreatePlaceDto createPlaceDto=new CreatePlaceDto();
        createPlaceDto.setId(200);
        createPlaceDto.setNumber(200);
        createPlaceDto.setRow(200);

        Place expected=new Place();
        expected.setNumber(200);
        expected.setRow(200);

        Place actual = target.convertToEntity(createPlaceDto);

        assertThat(actual).isEqualTo(expected);
    }
}