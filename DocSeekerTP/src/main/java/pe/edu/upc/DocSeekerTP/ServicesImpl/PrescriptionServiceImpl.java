package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.PrescriptionRepository;
import pe.edu.upc.DocSeekerTP.Services.PrescriptionService;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;
import pe.edu.upc.DocSeekerTP.entities.Prescription;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
     PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription save(Prescription prescription){

        if (prescription.getMedicine()==null || prescription.getDetails()==null){
            throw new IncompleteDataException("Ingrese todos los datos");
        }
        return prescriptionRepository.save(prescription);
    }
    @Override
    public void delete(Long id){
        Prescription prescription = findById(id);
        prescriptionRepository.delete(prescription);
    }

    public Prescription findById(Long id) {
        Prescription prescriptionFound =prescriptionRepository.findById(id).orElse(null);
        if (prescriptionFound==null){
            throw new ResourceNotFoundException("No se encontro horario registrado" +String.valueOf(id));
        }
        return prescriptionFound;
    }

    @Override
    public List<Prescription> listAll() {
        List<Prescription> prescriptionTimes = prescriptionRepository.findAll();
        for (Prescription p: prescriptionTimes) {
            p.setId(null);
        }
        return prescriptionTimes;
    }
}
