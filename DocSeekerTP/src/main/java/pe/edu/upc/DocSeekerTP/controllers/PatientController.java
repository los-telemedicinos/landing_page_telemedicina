package pe.edu.upc.DocSeekerTP.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.entities.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "patient")
public class PatientController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Appointment> getAll(){
        List<Appointment> list_appointments = new ArrayList<>();
        Appointment appointment = new Appointment();

        return list_appointments;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Appointment get(@PathVariable long id){
        Appointment appointment = new Appointment();
        appointment.setId(2);
        appointment.setAppointmentDate(LocalDate.parse("2024-05-21"));
        appointment.setReason("Estoy con tos");
        appointment.setState("Sticky");
        appointment.setRegisterDate_Appointment(LocalDate.parse("2024-05-22"));
        appointment.setPatient_id_Patient(5);
        appointment.setPrescription_id(58);
        appointment.setDoctor_id_Doctor(5);
        return appointment;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Appointment register(@RequestBody Appointment appointment){
        // Registrar en la base de datos
        return appointment;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Appointment update(@RequestBody Appointment appointment){
        // Actualizar en la base de datos
        return appointment;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
