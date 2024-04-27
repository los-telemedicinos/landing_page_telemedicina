package pe.edu.upc.DocSeekerTP.controllers;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.DocSeekerTP.entities.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "doc_appointment")
public class AppointmentController {

    //@Data
    @RequestMapping("create")
    List<Appointment> getAll(){
        List<Appointment> list = new ArrayList<>();
        Appointment appointment = new Appointment();
        appointment.setId(2);
        appointment.setAppointmentDate(LocalDate.parse("21-05-2024"));
    }
}
