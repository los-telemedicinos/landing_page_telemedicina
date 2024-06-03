package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.KeyRepeatedDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.PatientRepository;
import pe.edu.upc.DocSeekerTP.Services.PatientService;
import pe.edu.upc.DocSeekerTP.entities.Patient;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> listAll() {
        List<Patient> patients = patientRepository.findAll();
        for (Patient e: patients) {
            e.setAppointments(null);
        }
        return patients;
    }

    @Override
    public Patient findById(Long id) {
        Patient patientFound = patientRepository.findById(id).orElse(null);
        if (patientFound == null) {
            throw new ResourceNotFoundException("No se encontró paciente con este id: " + String.valueOf(id));
        }
        return patientFound;
    }

    @Override
    public Patient save(Patient patient) {
        if (patient.getName()==null || patient.getName().isEmpty() || patient.getDni()==null||
                patient.getDni().isEmpty()||patient.getEmail().isEmpty()||patient.getAddress().isEmpty()) {
            throw new IncompleteDataException("Ingrese todos los datos");
        }
        List<Patient> listPatientDuplicated = patientRepository.findAllByDni(patient.getDni());
            for (Patient pat : listPatientDuplicated) {
                if(patient.getDni().equals(pat.getDni())){
                    throw new KeyRepeatedDataException("Este DNI ya se registró");
                }

            }
            return patientRepository.save(patient);
        }
}