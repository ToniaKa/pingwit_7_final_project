package pl.pingwit.pingwitseatreservations.controller.booking;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.BookingDto;
import pl.pingwit.pingwitseatreservations.controller.booking.dto.CreateBookingDto;
import pl.pingwit.pingwitseatreservations.service.booking.BookingService;

@Tag(name = "Booking API")
@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable(name = "id") Integer id) {
        return bookingService.getBooking(id);
    }

    @PostMapping
    public Integer createBooking(@RequestBody CreateBookingDto createBookingDto) {
        return bookingService.createBooking(createBookingDto);
    }
}
