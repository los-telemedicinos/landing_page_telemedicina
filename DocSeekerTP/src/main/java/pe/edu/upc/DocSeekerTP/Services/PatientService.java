package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> listAll();

    Patient findById(Long id);

    Patient save(Patient patient);
}
