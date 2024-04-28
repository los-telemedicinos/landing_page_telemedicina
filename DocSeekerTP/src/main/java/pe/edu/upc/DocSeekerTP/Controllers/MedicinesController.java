package pe.edu.upc.DocSeekerTP.Controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Entities.Medicines;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "medicines")
public class MedicinesController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Medicines> getAll(){
        List<Medicines> list_Medicines = new ArrayList<>();
        Medicines medicines = new Medicines();
        medicines.setId_Medicines(1);
        medicines.setName_Medicines("Paracetamol");
        list_Medicines.add(medicines);
        return list_Medicines;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Medicines get(@PathVariable long id){
        Medicines medicines = new Medicines();
        medicines.setId_Medicines(1);
        medicines.setName_Medicines("Paracetamol");
        return medicines;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Medicines register(@RequestBody Medicines medicines){
        // Registrar en la base de datos
        return medicines;
    }

    @RequestMapping(value = "/{id_Medicines}", method = RequestMethod.PUT)
    Medicines update(@RequestBody Medicines medicines){
        // Actualizar en la base de datos
        return medicines;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
