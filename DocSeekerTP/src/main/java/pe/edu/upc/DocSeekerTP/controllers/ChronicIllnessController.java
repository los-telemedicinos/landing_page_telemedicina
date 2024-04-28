package pe.edu.upc.DocSeekerTP.controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.entities.ChronicIllness;
import pe.edu.upc.DocSeekerTP.entities.ChronicIllness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("list_chronic_illness")
public class ChronicIllnessController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ChronicIllness> getAll(){
        List<ChronicIllness> list_ChronicIllness = new ArrayList<>();
        ChronicIllness chronicIllness = new ChronicIllness();
        chronicIllness.setId_Illness(1);
        chronicIllness.setAsthma(false);
        chronicIllness.setDiabetes(false);
        chronicIllness.setArthritis(false);
        chronicIllness.setHypertension(false);
        chronicIllness.setDepression(false);
        chronicIllness.setHighCholesterol(false);
        chronicIllness.setGynecologicalProblems(false);
        chronicIllness.setOsteoporosis(false);
        chronicIllness.setCardiovascular(false);
        chronicIllness.setOthers("");
        list_ChronicIllness.add(chronicIllness);
        return list_ChronicIllness;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ChronicIllness get(@PathVariable long id){
        ChronicIllness chronicIllness = new ChronicIllness();
        chronicIllness.setId_Illness(1);
        chronicIllness.setAsthma(false);
        chronicIllness.setDiabetes(false);
        chronicIllness.setArthritis(false);
        chronicIllness.setHypertension(false);
        chronicIllness.setDepression(false);
        chronicIllness.setHighCholesterol(false);
        chronicIllness.setGynecologicalProblems(false);
        chronicIllness.setOsteoporosis(false);
        chronicIllness.setCardiovascular(false);
        chronicIllness.setOthers("");
        return chronicIllness;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ChronicIllness register(@RequestBody ChronicIllness chronicIllness){
        // Registrar en la base de datos
        return chronicIllness;
    }

    @RequestMapping(value = "/{id_Illness}", method = RequestMethod.PUT)
    ChronicIllness update(@RequestBody ChronicIllness chronicIllness){
        // Actualizar en la base de datos
        return chronicIllness;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
