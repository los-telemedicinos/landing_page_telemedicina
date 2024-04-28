package pe.edu.upc.DocSeekerTP.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.entities.Doctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "doctor")
public class DoctorController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Doctor> getAll(){
        List<Doctor> list_Doctors = new ArrayList<>();
        Doctor doctor = new Doctor();
        doctor.setId_Doctor(1);
        doctor.setName("Thomas");
        doctor.setLastName("Borda");
        doctor.setSpeciality("Cardiology");
        doctor.setHospital("EsSalud");
        doctor.setDoctorDetails("It's a very good doctor, with 20 years old of experience");
        doctor.setUser_Id(5);
        doctor.setEmail("thomasborda@gmail.com");
        doctor.setDni("78965432");
        doctor.setTuitionNumber(5);
        list_Doctors.add(doctor);
        return list_Doctors;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Doctor get(@PathVariable long id){
        Doctor doctor = new Doctor();
        doctor.setId_Doctor(1);
        doctor.setName("Thomas");
        doctor.setLastName("Borda");
        doctor.setSpeciality("Cardiology");
        doctor.setHospital("EsSalud");
        doctor.setDoctorDetails("It's a very good doctor, with 20 years old of experience");
        doctor.setUser_Id(5);
        doctor.setEmail("thomasborda@gmail.com");
        doctor.setDni("78965432");
        doctor.setTuitionNumber(5);
        return doctor;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Doctor register(@RequestBody Doctor doctor){
        // Registrar en la base de datos
        return doctor;
    }

    @RequestMapping(value = "/{id_Doctor}", method = RequestMethod.PUT)
    Doctor update(@RequestBody Doctor doctor){
        // Actualizar en la base de datos
        return doctor;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
