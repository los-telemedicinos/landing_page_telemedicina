package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Services.DoctorTimeService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctors")
public class Doctor_TimeController {
    @Autowired
    DoctorTimeService doctorTimeService;
    @GetMapping("/time")
    public ResponseEntity<List<Doctor_Time>> getDoctor() {
        List<Doctor_Time> doctortimes = doctorTimeService.listAll();
        return new ResponseEntity<List<Doctor_Time>>(doctortimes, HttpStatus.OK);
    }

    @PostMapping("/time/register")
    public ResponseEntity<Doctor_Time> createTime(@RequestBody Doctor_Time doctorTime) {
        Doctor_Time newDoctorTime = doctorTimeService.save(doctorTime);
        return new ResponseEntity<Doctor_Time>(newDoctorTime, HttpStatus.CREATED);
    }

    //Pasa el id por el body
    @DeleteMapping("/doctors/{id}")
    public ResponseEntity<HttpStatus> deleteTime(@PathVariable("id") Long id) {
        doctorTimeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
