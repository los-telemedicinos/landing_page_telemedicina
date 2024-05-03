package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Services.PatientService;
import pe.edu.upc.DocSeekerTP.entities.Patient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/patient")
    public ResponseEntity<Patient> createEmployee(@RequestBody Patient patient) {
        Patient newPatient = patientService.save(patient);
        return new ResponseEntity<Patient>(newPatient, HttpStatus.CREATED);
    }
    @PutMapping("/patient/update")
    public ResponseEntity<Patient> updateProfilePatient(@RequestBody Patient patient) {
        Patient foundPatient = patientService.findById(patient.getId());

        if (patient.getAddress()!=null) {
            foundPatient.setAddress(patient.getAddress());
        }
        if (patient.getEmail()!=null) {
            foundPatient.setEmail(patient.getEmail());
        }
        if(patient.getPhoneNumber()!=null){
            foundPatient.setPhoneNumber(patient.getPhoneNumber());
        }
        Patient newEmployee = patientService.save(foundPatient);
        return new ResponseEntity<Patient>(newEmployee, HttpStatus.OK);
    }
}

