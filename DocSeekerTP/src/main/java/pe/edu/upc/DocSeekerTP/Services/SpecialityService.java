package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Speciality;

public interface SpecialityService {

    Speciality save(Speciality especiality);

    void delete(Long id);
    public Speciality findById(Long id);
}
