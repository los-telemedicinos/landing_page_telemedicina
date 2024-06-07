package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Prescription;

import java.util.List;

public interface PrescriptionService {

    public abstract void delete(Long id);

    Prescription save(Prescription prescription);

    Prescription findById(Long id);

    public abstract List<Prescription> listAll();
}
