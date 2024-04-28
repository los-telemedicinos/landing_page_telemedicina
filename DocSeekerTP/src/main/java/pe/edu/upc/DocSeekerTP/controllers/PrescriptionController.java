package pe.edu.upc.DocSeekerTP.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Entities.Prescription;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "prescription")
public class PrescriptionController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Prescription> getAll(){
        List<Prescription> list_Prescription = new ArrayList<>();
        Prescription prescription = new Prescription();
        prescription.setId(1);
        prescription.setMedicine("Paracetamol");
        prescription.setDetails("Tomar cada 8 horas por 5 días");
        list_Prescription.add(prescription);
        return list_Prescription;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Prescription get(@PathVariable long id){
        Prescription prescription = new Prescription();
        prescription.setId(1);
        prescription.setMedicine("Paracetamol");
        prescription.setDetails("Tomar cada 8 horas por 5 días");
        return prescription;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Prescription register(@RequestBody Prescription prescription){
        // Registrar en la base de datos
        return prescription;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Prescription update(@RequestBody Prescription prescription){
        // Actualizar en la base de datos
        return prescription;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
