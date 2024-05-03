package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Doctor;

import java.util.List;

public interface DoctorService {
    public List<Doctor> listAll();
    public Doctor save(Doctor doctor);
    public void delete(Long id);
    public Doctor findById(Long id);
}
