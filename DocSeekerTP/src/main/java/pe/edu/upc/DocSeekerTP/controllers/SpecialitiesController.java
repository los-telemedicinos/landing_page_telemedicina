package pe.edu.upc.DocSeekerTP.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.entities.Specialities;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "specialty")
public class SpecialitiesController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Specialities> getAll(){
        List<Specialities> list_Specialities = new ArrayList<>();
        Specialities specialities = new Specialities();
        specialities.setId_speciality(1);
        specialities.setSpeciality_name("Cardiology");
        list_Specialities.add(specialities);
        return list_Specialities;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Specialities get(@PathVariable long id){
        Specialities specialities = new Specialities();
        specialities.setId_speciality(1);
        specialities.setSpeciality_name("Cardiology");
        return specialities;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Specialities register(@RequestBody Specialities specialities){
        // Registrar en la base de datos
        return specialities;
    }

    @RequestMapping(value = "/{id_speciality}", method = RequestMethod.PUT)
    Specialities update(@RequestBody Specialities specialities){
        // Actualizar en la base de datos
        return specialities;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
