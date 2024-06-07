package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Medicine;

import java.util.List;

public interface MedicineService {
    List<Medicine> listAll();

    Medicine getById(Long id);

    Medicine save(Medicine medicine);

    void delete(Long id);
}
