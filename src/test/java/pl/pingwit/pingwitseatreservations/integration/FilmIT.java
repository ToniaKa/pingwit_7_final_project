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
import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.ClientFullDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.CreateClientDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.AgeRestrictionTypeDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.CreateFilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmDto;
import pl.pingwit.pingwitseatreservations.controller.film.dto.FilmFullDto;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@Testcontainers
@SpringBootTest(classes = {PingwitseatreservationsApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmIT {
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
    void verifyFilmLifecycle() {
        CreateFilmDto filmDto=new CreateFilmDto();
        filmDto.setId(101);
        filmDto.setName("Test name");
        filmDto.setYearOfRelease(LocalDate.of(2020,1,1));
        filmDto.setAgeRestrictionTypeDto(AgeRestrictionTypeDto.TEN_PLUS);
        filmDto.setDuration(120);


        // prepare request
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateFilmDto> request = new HttpEntity<>(filmDto, headers);

        String Url = "http://localhost:" + port + "/film";

        // film creation
        ResponseEntity<Integer> createdResponse = restTemplate.postForEntity(Url, request, Integer.class);

        assertThat(createdResponse.getStatusCode().is2xxSuccessful()).isTrue();
        Integer createdFilmId = createdResponse.getBody();

        // retrieve created film
        ResponseEntity<FilmDto> response = restTemplate.exchange(Url + "/" + createdFilmId, HttpMethod.GET, request, FilmDto.class);
        FilmDto body = response.getBody();


        assertThat(body.getName()).isEqualTo("Test name");
        assertThat(body.getYearOfRelease()).isEqualTo(LocalDate.of(2020,1,1));


        HttpEntity<CreateFilmDto> request2 = new HttpEntity<>(headers);
        ResponseEntity<List<FilmFullDto>> exchange = restTemplate.exchange(Url, HttpMethod.GET, request2, new ParameterizedTypeReference<List<FilmFullDto>>() {
        });

        assertThat(exchange.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(exchange.getBody().size()).isEqualTo(1);
    }
}
