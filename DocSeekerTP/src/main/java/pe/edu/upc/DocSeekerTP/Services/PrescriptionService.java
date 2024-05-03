package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;
import pe.edu.upc.DocSeekerTP.entities.Prescription;

import java.util.List;

public interface PrescriptionService {
    public abstract Doctor_Time save(Doctor_Time doctor_time);

    public abstract Prescription save(Prescription prescription);

    public abstract void delete(Long id);

    public abstract List<Prescription> listAll();
}
