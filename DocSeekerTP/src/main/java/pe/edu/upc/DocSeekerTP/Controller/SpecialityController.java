package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Dtos.DTOSpeciality;
import pe.edu.upc.DocSeekerTP.Services.DoctorService;
import pe.edu.upc.DocSeekerTP.Services.SpecialityService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Speciality;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctors")
public class SpecialityController {
    @Autowired
    SpecialityService specialityService;
    @PostMapping("/speciality")
    public ResponseEntity<Speciality> createSpeciality(@RequestBody Speciality speciality) {
        Speciality newSpeciality = specialityService.save(speciality);
        return new ResponseEntity<Speciality>(newSpeciality, HttpStatus.CREATED);
    }

    //Pasa el id por el body
    @DeleteMapping("/speciality/{id}")
    public ResponseEntity<HttpStatus> deleteSpeciality(@PathVariable("id") Long id) {
        specialityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*
    @Autowired
    DoctorService doctorService;
    @PostMapping("/speciality")
    public ResponseEntity<List<Doctor>> getDoctorsBySpeciality(@RequestBody DTOSpeciality requestDTO) {
        List<Doctor> doctors = doctorService.findDoctorsBySpeciality(requestDTO.getNameSpeciality());
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

     */
}
