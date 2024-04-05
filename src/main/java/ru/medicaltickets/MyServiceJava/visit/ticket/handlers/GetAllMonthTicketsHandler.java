package ru.medicaltickets.MyServiceJava.visit.ticket.handlers;

import org.springframework.http.ResponseEntity;
import ru.medicaltickets.MyServiceJava.user.doctor.enums.DoctorSpecialty;
import ru.medicaltickets.MyServiceJava.visit.ticket.TicketService;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class GetAllMonthTicketsHandler {
    private final TicketService ticketService;

    public GetAllMonthTicketsHandler(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<List<?>> handle(String clinicID, String dateOfMonday) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDateOfMonday = LocalDate.parse(dateOfMonday);
        return ticketService.getMonthScheduleByClinic(parsedClinicID, parsedDateOfMonday);
    }

    public ResponseEntity<List<?>> handle(String clinicID, String date, String doctorSpecialty) {
        Long parsedClinicID = Long.valueOf(clinicID);
        LocalDate parsedDate = LocalDate.parse(date);
        DoctorSpecialty parsedDoctorSpecialty = DoctorSpecialty.valueOf(doctorSpecialty);
        return ticketService.getMonthScheduleByClinicAndDoctorsSpecialty(parsedClinicID, parsedDoctorSpecialty, parsedDate);
    }
}
