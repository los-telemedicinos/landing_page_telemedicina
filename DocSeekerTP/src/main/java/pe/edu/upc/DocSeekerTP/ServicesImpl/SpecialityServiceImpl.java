package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.SpecialityRepository;
import pe.edu.upc.DocSeekerTP.Services.SpecialityService;
import pe.edu.upc.DocSeekerTP.entities.Speciality;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    SpecialityRepository specialityRepository;
    @Override
    public Speciality save(Speciality especiality){
        if(especiality.getSpeciality_name()==null||especiality.getSpeciality_name().isEmpty()){
            throw new IncompleteDataException("El nombre de la especialidad no se ha registrado");
        }
        return specialityRepository.save(especiality);
    }
    @Override
    public void delete(Long id){
        Speciality speciality = findById(id);
        specialityRepository.delete(speciality);
    }

    public Speciality findById(Long id) {
        Speciality specialityFound =specialityRepository.findById(id).orElse(null);
        if (specialityFound==null){
            throw new ResourceNotFoundException("No se encontró una especialidad con este Id" +String.valueOf(id));
        }
        return specialityFound;
    }

}
