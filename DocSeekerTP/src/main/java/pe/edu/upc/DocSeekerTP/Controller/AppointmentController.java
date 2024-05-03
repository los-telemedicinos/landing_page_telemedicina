package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentSummary;
import pe.edu.upc.DocSeekerTP.Services.AppointmentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointments/summary")
    public ResponseEntity<List<DTOAppointmentSummary>> getProjectsSummary() {
        List<DTOAppointmentSummary> dtoProjectSummaryList = appointmentService.listAppointmentSummary();
        return new ResponseEntity<List<DTOAppointmentSummary>>(dtoProjectSummaryList, HttpStatus.OK);
    }
}