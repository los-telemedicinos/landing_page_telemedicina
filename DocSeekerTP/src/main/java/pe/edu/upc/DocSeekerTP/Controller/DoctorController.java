package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.DocSeekerTP.Services.DoctorService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class DoctorController {
   @Autowired
    DoctorService doctorService;
   @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getDoctor(){
       List<Doctor> doctors =doctorService.listAll();
       return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
   }
}
