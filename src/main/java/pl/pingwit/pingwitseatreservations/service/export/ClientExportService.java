package pl.pingwit.pingwitseatreservations.service.export;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitseatreservations.repository.booking.Booking;
import pl.pingwit.pingwitseatreservations.repository.booking.BookingRepository;
import pl.pingwit.pingwitseatreservations.repository.client.Client;
import pl.pingwit.pingwitseatreservations.repository.client.ClientRepository;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeat;
import pl.pingwit.pingwitseatreservations.repository.reservedSeats.ReservedSeatsRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ClientExportService {
    private final ClientRepository clientRepository;
    private final BookingRepository bookingRepository;
    private final ReservedSeatsRepository reservedSeatsRepository;

    public ClientExportService(ClientRepository clientRepository, BookingRepository bookingRepository, ReservedSeatsRepository reservedSeatsRepository) {
        this.clientRepository = clientRepository;
        this.bookingRepository = bookingRepository;
        this.reservedSeatsRepository = reservedSeatsRepository;
    }

    public byte[] exportClients() throws IOException {
        List<Client> clients = clientRepository.findAll();
        List<Booking> bookings = bookingRepository.findAll();
        List<ReservedSeat> reservedSeats = reservedSeatsRepository.findAll();


        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Clients");
            // Create header row
            createHeader(sheet);
            // Create data rows
            createDataRows(clients, sheet);

            Sheet workbookSheet = workbook.createSheet("Bookings");

            createHeaderBooking(workbookSheet);
            createDataRowsBookings(bookings, workbookSheet);

            Sheet seats = workbook.createSheet("Reserved seats");
            createHeaderSeat(seats);
            createDataRowsSeats(reservedSeats, seats);


            // Write Excel to ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        }
    }

    private void createDataRows(List<Client> clients, Sheet sheet) {
        int rowNum = 1;
        for (Client client : clients) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(client.getId());
            row.createCell(1).setCellValue(client.getName());
            row.createCell(2).setCellValue(client.getSurname());
            row.createCell(3).setCellValue(client.getEmail());
            row.createCell(4).setCellValue(client.getPhone());
        }
    }

    private void createHeader(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Surname");
        headerRow.createCell(3).setCellValue("Email");
        headerRow.createCell(4).setCellValue("Phone");
    }

    private void createDataRowsBookings(List<Booking> bookings, Sheet sheet) {
        int n = 1;
        for (Booking booking : bookings) {
            Row row = sheet.createRow(n++);
            row.createCell(0).setCellValue(booking.getId());
            row.createCell(1).setCellValue(booking.getClient().getName());
            row.createCell(2).setCellValue(booking.getTimeOfPurchase());
        }
    }

    private void createDataRowsSeats(List<ReservedSeat> seats, Sheet sheets) {
        int n = 1;
        for (ReservedSeat reservedSeat : seats) {
            Row row = sheets.createRow(n++);
            row.createCell(0).setCellValue(reservedSeat.getId());
            row.createCell(1).setCellValue(reservedSeat.getBooking().getClient().getName());
            row.createCell(2).setCellValue(reservedSeat.getBooking().getClient().getSurname());
            row.createCell(3).setCellValue(reservedSeat.getPlace().getRow());
            row.createCell(4).setCellValue(reservedSeat.getPlace().getNumber());
            row.createCell(5).setCellValue(reservedSeat.getSession().getFilm().getName());
            row.createCell(6).setCellValue(reservedSeat.getSession().getFilm().getDuration());
            row.createCell(7).setCellValue(reservedSeat.getSession().getFilm().getYearOfRelease());
            row.createCell(8).setCellValue(reservedSeat.getSession().getStartDateAndTime());
        }
    }

    private void createHeaderBooking(Sheet sheet) {
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Time of Purchase");
    }

    private void createHeaderSeat(Sheet sheets) {
        Row headerRow = sheets.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Surname");
        headerRow.createCell(3).setCellValue("Row");
        headerRow.createCell(4).setCellValue("Number");
        headerRow.createCell(5).setCellValue("Film");
        headerRow.createCell(6).setCellValue("Duration");
        headerRow.createCell(7).setCellValue("Year of release");
        headerRow.createCell(8).setCellValue("Start date and time");
    }
}
