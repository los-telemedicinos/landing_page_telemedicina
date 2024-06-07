package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Services.PrescriptionService;
import pe.edu.upc.DocSeekerTP.entities.Prescription;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @GetMapping("/prescription")
    public ResponseEntity<List<Prescription>> getPrescription() {
        List<Prescription> prescriptions = prescriptionService.listAll();
        return new ResponseEntity<List<Prescription>>(prescriptions, HttpStatus.OK);
    }

    @PostMapping("/prescription")
    public ResponseEntity<Prescription> create(@RequestBody Prescription prescription) {
        Prescription prescriptions = prescriptionService.save(prescription);
            return new ResponseEntity<Prescription>(prescriptions, HttpStatus.CREATED);
    }
}
