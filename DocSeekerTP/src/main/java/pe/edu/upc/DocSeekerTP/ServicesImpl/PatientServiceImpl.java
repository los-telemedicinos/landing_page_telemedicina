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
        List<Patient> employees = patientRepository.findAll();
        for (Patient e: employees) {
            e.setAppointments(null);
        }
        return employees;
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
        if (patient.getName()==null || patient.getName().isEmpty()) {
            throw new IncompleteDataException("Employee name can not be null or empty");
        }
        List<Patient> listEmployeeNameDuplicated= patientRepository.findByNameContaining(patient.getName());
        if (listEmployeeNameDuplicated.size()>1 || (listEmployeeNameDuplicated.size()==1 && !listEmployeeNameDuplicated.get(0).getId().equals(patient.getId())) ) {
            throw new KeyRepeatedDataException("Employee name can not be duplicated");
        }
        return patientRepository.save(patient);
    }
}