package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentCreate;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentSummary;
import pe.edu.upc.DocSeekerTP.Services.AppointmentService;
import pe.edu.upc.DocSeekerTP.entities.Appointment;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointment/summary")
    public ResponseEntity<List<DTOAppointmentSummary>> getProjectsSummary() {
        List<DTOAppointmentSummary> dtoProjectSummaryList = appointmentService.listAppointmentSummary();
        return new ResponseEntity<List<DTOAppointmentSummary>>(dtoProjectSummaryList, HttpStatus.OK);
    }

    @PostMapping("/appointment/register")
    public ResponseEntity<Appointment> createAppointment(@RequestBody DTOAppointmentCreate requestDTO) {
        Appointment newAppointment = appointmentService.createAppointment(requestDTO);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }
} //debo corregir esto
//la relación?