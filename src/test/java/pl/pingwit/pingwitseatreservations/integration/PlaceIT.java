package pl.pingwit.pingwitseatreservations.integration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.client.RestTemplate;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import pl.pingwit.pingwitseatreservations.PingwitseatreservationsApplication;
import pl.pingwit.pingwitseatreservations.controller.place.dto.CreatePlaceDto;
import pl.pingwit.pingwitseatreservations.controller.place.dto.PlaceDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@Testcontainers
@SpringBootTest(classes = {PingwitseatreservationsApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlaceIT {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:12");
    @LocalServerPort
    private Integer port;

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getPassword);
        registry.add("spring.datasource.password", postgres::getUsername);
        registry.add("spring.datasource.driver-class-name", postgres::getDriverClassName);
    }

    @Test
    void verifyProductLifecycle() {
        CreatePlaceDto placeDto=new CreatePlaceDto();
        placeDto.setNumber(1);
        placeDto.setRow(1);


        // prepare request
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setBasicAuth("admin", "admin");
        HttpEntity<CreatePlaceDto> request = new HttpEntity<>(placeDto, headers);

        String Url = "http://localhost:" + port + "/rental-center";

        // rental center creation
        ResponseEntity<Integer> createdResponse = restTemplate.postForEntity(Url, request, Integer.class);
        assertThat(createdResponse.getStatusCode().is2xxSuccessful()).isTrue();
        Integer createdPlaceId = createdResponse.getBody();

        // retrieve created rental center
        ResponseEntity<PlaceDto> response = restTemplate.exchange(Url + "/" + createdPlaceId, HttpMethod.GET, request, PlaceDto.class);
        PlaceDto body = response.getBody();


        assertThat(body.getNumber().equals(1));
        assertThat(body.getRow().equals(1));

    }
}
