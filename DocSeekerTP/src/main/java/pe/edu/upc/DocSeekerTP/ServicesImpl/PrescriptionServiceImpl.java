package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.MedicineRepository;
import pe.edu.upc.DocSeekerTP.Repository.PrescriptionRepository;
import pe.edu.upc.DocSeekerTP.Services.PrescriptionService;
import pe.edu.upc.DocSeekerTP.entities.Prescription;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
     PrescriptionRepository prescriptionRepository;
    MedicineRepository medicineRepository;

    @Override
    public Prescription save(Prescription prescription) {

        return prescriptionRepository.save(prescription);
    }

    @Override
    public Prescription findById(Long id) {
        Prescription prescriptionFound =prescriptionRepository.findById(id).orElse(null);
        if (prescriptionFound==null){
            throw new ResourceNotFoundException("No se encontró receta registrada" +String.valueOf(id));
        }
        return prescriptionFound;
    }

    @Override
    public List<Prescription> listAll() {

        return prescriptionRepository.findAll();
    }
    @Override
    public void delete(Long id){
        Prescription prescription = findById(id);
        prescriptionRepository.delete(prescription);
    }
}
