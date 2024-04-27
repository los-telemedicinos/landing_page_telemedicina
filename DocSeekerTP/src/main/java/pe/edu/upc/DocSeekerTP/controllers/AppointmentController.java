package pe.edu.upc.DocSeekerTP.controllers;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.DocSeekerTP.entities.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "doc_appointment")
public class AppointmentController {

    //@Data
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Appointment> getAll(){
        List<Appointment> list_appointments = new ArrayList<>();
        Appointment appointment = new Appointment();
        appointment.setId(2);
        appointment.setAppointmentDate(LocalDate.parse("2024-05-21"));
        appointment.setReason("Estoy con tos");
        appointment.setState("Sticky");
        appointment.setRegisterDate_Appointment(LocalDate.parse("2024-05-22"));
        appointment.setPatient_id_Patient(5);
        appointment.setPrescription_id(58);
        appointment.setDoctor_id_Doctor(5);
        list_appointments.add(appointment);
        return list_appointments;
    }
}
