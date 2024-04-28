package pe.edu.upc.DocSeekerTP.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "doc_time")
public class Doctor_TimeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Doctor_Time> getAll(){
        List<Doctor_Time> list_Doctor_Time = new ArrayList<>();
        Doctor_Time doctor_Time = new Doctor_Time();
        doctor_Time.setId_time(1);
        doctor_Time.setDoctor_id_doctor(1);
        doctor_Time.setDay(LocalDate.parse("2024-04-28"));
        doctor_Time.setStartTime("08:00");
        doctor_Time.setEndTime("18:00");
        list_Doctor_Time.add(doctor_Time);
        return list_Doctor_Time;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Doctor_Time get(@PathVariable long id){
        Doctor_Time doctor_Time = new Doctor_Time();
        doctor_Time.setId_time(1);
        doctor_Time.setDoctor_id_doctor(1);
        doctor_Time.setDay(LocalDate.parse("2024-04-28"));
        doctor_Time.setStartTime("08:00");
        doctor_Time.setEndTime("18:00");
        return doctor_Time;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Doctor_Time push(@RequestBody Doctor_Time doctor_Time){
        // Registrar en la base de datos
        return doctor_Time;
    }

    @RequestMapping(value = "/{id_time}", method = RequestMethod.PUT)
    Doctor_Time update(@RequestBody Doctor_Time doctor_Time){
        // Actualizar en la base de datos
        return doctor_Time;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
