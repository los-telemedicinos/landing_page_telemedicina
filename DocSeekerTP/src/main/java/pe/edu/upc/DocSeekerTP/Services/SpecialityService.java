package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Speciality;

import java.util.List;

public interface SpecialityService {

    List<Speciality> listAll();

    public Speciality save(Speciality especiality);
    void delete(Long id);
    public Speciality findById(Long id);



}
