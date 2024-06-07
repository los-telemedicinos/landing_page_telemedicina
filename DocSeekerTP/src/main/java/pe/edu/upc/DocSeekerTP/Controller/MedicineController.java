package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Services.MedicineService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Medicine;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MedicineController {

    @Autowired
    MedicineService medicineService;
    @GetMapping("/medicines")
    public ResponseEntity<List<Medicine>> getMedicines() {
        List<Medicine> medicines = medicineService.listAll();
        return new ResponseEntity<List<Medicine>>(medicines, HttpStatus.OK);
    }
    @PostMapping("/medicines")
    public ResponseEntity<Medicine> create(@RequestBody Medicine medicine) {
        Medicine savedMedicine = medicineService.save(medicine);
        return new ResponseEntity<Medicine>(savedMedicine,HttpStatus.CREATED);
    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        medicineService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
