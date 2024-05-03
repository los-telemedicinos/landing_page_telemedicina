package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Services.DoctorService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class DoctorController {
    @Autowired
    DoctorService doctorService;

    //http://localhost:8080/api/doctors
   @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getDoctor() {
        List<Doctor> doctors = doctorService.listAll();
        return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
    }

    @PostMapping("/doctors/register")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor newDoctor = doctorService.save(doctor);
        return new ResponseEntity<Doctor>(newDoctor, HttpStatus.CREATED);
    }

    //Pasa el id por el body
    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        doctorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}