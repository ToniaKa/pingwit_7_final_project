package pl.pingwit.pingwitseatreservations.integration;

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


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Testcontainers
@SpringBootTest(classes = {PingwitseatreservationsApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientIT {

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
    void verifyClientLifecycle() {
        CreateClientDto clientDto = new CreateClientDto();
        clientDto.setId(21);
        clientDto.setName("Test name");
        clientDto.setSurname("Test surname");
        clientDto.setPhone("12345");
        clientDto.setEmail("test@gmail.com");


        // prepare request
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("admin", "admin");
        HttpEntity<CreateClientDto> request = new HttpEntity<>(clientDto, headers);

        String Url = "http://localhost:" + port + "/client";

        // client creation
        ResponseEntity<Integer> createdResponse = restTemplate.postForEntity(Url, request, Integer.class);

        assertThat(createdResponse.getStatusCode().is2xxSuccessful()).isTrue();
        Integer createdClientId = createdResponse.getBody();

        // retrieve created client
        ResponseEntity<ClientDto> response = restTemplate.exchange(Url + "/" + createdClientId, HttpMethod.GET, request, ClientDto.class);
        ClientDto body = response.getBody();


        assertThat(body.getName()).isEqualTo("Test name");
        assertThat(body.getSurname()).isEqualTo("Test surname");


        HttpEntity<CreateClientDto> request2 = new HttpEntity<>(headers);
        ResponseEntity<List<ClientFullDto>> exchange = restTemplate.exchange(Url, HttpMethod.GET, request2, new ParameterizedTypeReference<List<ClientFullDto>>() {
        });

        assertThat(exchange.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(exchange.getBody().size()).isEqualTo(1);
    }
}
