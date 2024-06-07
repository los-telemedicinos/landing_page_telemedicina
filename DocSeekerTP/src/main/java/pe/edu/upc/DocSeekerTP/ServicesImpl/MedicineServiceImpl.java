package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.MedicineRepository;
import pe.edu.upc.DocSeekerTP.Services.MedicineService;
import pe.edu.upc.DocSeekerTP.entities.Medicine;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;
    @Override
    public List<Medicine> listAll() {

        return medicineRepository.findAll();
    }

    @Override
    public Medicine getById(Long id) {
        Medicine medicineFound =medicineRepository.findById(id).orElse(null);
        if (medicineFound ==null){
            throw new ResourceNotFoundException("No se encontró una medicina con este id" +String.valueOf(id));
        }
        return medicineFound;
    }
    @Override
    public Medicine save(Medicine medicine) {

        return medicineRepository.save(medicine);
    }

    @Override
    public void delete(Long id){
        Medicine medicine = getById(id);
        medicineRepository.delete(medicine);
    }


}
