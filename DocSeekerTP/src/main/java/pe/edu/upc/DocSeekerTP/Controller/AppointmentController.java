package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentSummary;
import pe.edu.upc.DocSeekerTP.Services.AppointmentService;
import pe.edu.upc.DocSeekerTP.entities.Appointment;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointment")
    public ResponseEntity<List<DTOAppointmentSummary>> getAppointmentsSummary() {
        List<DTOAppointmentSummary> dtoProjectSummaryList = appointmentService.listAppointmentSummary();
        return new ResponseEntity<List<DTOAppointmentSummary>>(dtoProjectSummaryList, HttpStatus.OK);
    }

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment newAppointment = appointmentService.save(appointment);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }
}
