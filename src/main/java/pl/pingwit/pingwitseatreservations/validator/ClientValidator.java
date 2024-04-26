package pl.pingwit.pingwitseatreservations.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pl.pingwit.pingwitseatreservations.controller.client.dto.CreateClientDto;
import pl.pingwit.pingwitseatreservations.controller.client.dto.UpdateClientInputDto;
import pl.pingwit.pingwitseatreservations.exceptionhandling.SeatReservationsValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class ClientValidator {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d+");

    public void validateOnCreate(CreateClientDto clientDto) {

        List<String> errors = new ArrayList<>();

        if (StringUtils.isBlank(clientDto.getName())) {
            errors.add("Name is blank");
        }
        if (StringUtils.isBlank(clientDto.getSurname())) {
            errors.add("Surname is blank");
        }
        if (!EMAIL_PATTERN.matcher(clientDto.getEmail()).matches()) {
            errors.add("Email is invalid: " + clientDto.getEmail());
        }
        if (!PHONE_NUMBER_PATTERN.matcher(clientDto.getPhone()).matches()) {
            errors.add("Phone can contain only numbers: " + clientDto.getPhone());
        }

        if (!errors.isEmpty()) {
            throw new SeatReservationsValidationException("Client data is invalid ", errors);
        }
    }

    public void validateOnUpdate(UpdateClientInputDto inputDto) {
        List<String> errors = new ArrayList<>();

        if (StringUtils.isBlank(inputDto.getName())) {
            errors.add("Name is blank");
        }
        if (StringUtils.isBlank(inputDto.getSurname())) {
            errors.add("Surname is blank");
        }
        if (!EMAIL_PATTERN.matcher(inputDto.getEmail()).matches()) {
            errors.add("Email is invalid: " + inputDto.getEmail());
        }
        if (!PHONE_NUMBER_PATTERN.matcher(inputDto.getPhone()).matches()) {
            errors.add("Phone can contain only numbers: " + inputDto.getPhone());
        }

        if (!errors.isEmpty()) {
            throw new SeatReservationsValidationException("Client data is invalid ", errors);
        }
    }
}
