package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Services.TechnicalFileService;
import pe.edu.upc.DocSeekerTP.entities.Medicine;
import pe.edu.upc.DocSeekerTP.entities.Technical_file;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TechnicalFileController {
    @Autowired
    TechnicalFileService technicalFileService;
    @GetMapping("/technicalFile")
    public List<Technical_file> listAll() {

        return technicalFileService.listAll();
    }

    @PostMapping("/technicalFile")
    public ResponseEntity<Technical_file> registerTechnicalFile(@RequestBody Technical_file technicalFile){
        Technical_file newTechnicalFile =technicalFileService.save(technicalFile);
        return new ResponseEntity<>(newTechnicalFile, HttpStatus.CREATED);
    }

}
