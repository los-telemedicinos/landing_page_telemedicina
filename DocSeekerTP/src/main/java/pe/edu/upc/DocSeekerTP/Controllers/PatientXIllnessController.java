package pe.edu.upc.DocSeekerTP.Controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Entities.PatientXIllness;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "patient_controller")
public class PatientXIllnessController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<PatientXIllness> getAll(){
        List<PatientXIllness> list_PatientXIllness = new ArrayList<>();
        PatientXIllness patientXIllness = new PatientXIllness();
        patientXIllness.setId(1);
        patientXIllness.setPatient_Id_Patient(1);
        patientXIllness.setBloodType("O+");
        patientXIllness.setPrivateMedicine("Paracetamol");
        patientXIllness.setChronicIllnesses_id_Illness(1);
        list_PatientXIllness.add(patientXIllness);
        return list_PatientXIllness;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    PatientXIllness get(@PathVariable long id){
        PatientXIllness patientXIllness = new PatientXIllness();
        patientXIllness.setId(1);
        patientXIllness.setPatient_Id_Patient(1);
        patientXIllness.setBloodType("O+");
        patientXIllness.setPrivateMedicine("Paracetamol");
        patientXIllness.setChronicIllnesses_id_Illness(1);
        return patientXIllness;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    PatientXIllness register(@RequestBody PatientXIllness patientXIllness){
        // Registrar en la base de datos
        return patientXIllness;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    PatientXIllness update(@RequestBody PatientXIllness patientXIllness){
        // Actualizar en la base de datos
        return patientXIllness;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
