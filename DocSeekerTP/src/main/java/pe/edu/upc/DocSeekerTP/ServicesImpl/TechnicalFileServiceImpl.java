package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Repository.PatientRepository;
import pe.edu.upc.DocSeekerTP.Repository.TechnicalFileRepository;
import pe.edu.upc.DocSeekerTP.Services.TechnicalFileService;
import pe.edu.upc.DocSeekerTP.entities.Patient;
import pe.edu.upc.DocSeekerTP.entities.Technical_file;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicalFileServiceImpl implements TechnicalFileService {
    @Autowired
    TechnicalFileRepository technicalFileRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Technical_file> listAll() {

        return technicalFileRepository.findAll();
    }

    @Override
    public Technical_file save(Technical_file technical_file){
        // Verificar si el paciente existe
        Long patientId = technical_file.getPatient().getId();
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isEmpty()) {
            throw new IllegalArgumentException("Paciente no encontrado");
        }
        // Verificar si el paciente ya tiene un Technical_file asociado
        Optional<Technical_file> existingTechnicalFile = technicalFileRepository.findByPatientId(patientId);
        if (existingTechnicalFile.isPresent()) {
            throw new IllegalArgumentException("Este paciente ya tiene un Technical_file");
        }

        // Asociar el paciente existente al technical_file
        technical_file.setPatient(optionalPatient.get());

        // Guardar el technical_file
        return technicalFileRepository.save(technical_file);
    }
}
