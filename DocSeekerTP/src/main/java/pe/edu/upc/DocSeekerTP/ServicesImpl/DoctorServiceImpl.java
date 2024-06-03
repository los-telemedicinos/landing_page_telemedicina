package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.DoctorRepository;
import pe.edu.upc.DocSeekerTP.Repository.SpecialityRepository;
import pe.edu.upc.DocSeekerTP.Services.DoctorService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Override

    public List<Doctor> listAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        for (Doctor d : doctors) {
            d.setAppointments(null);
        }
        return doctors;
    }

    @Override
    public Doctor  save(Doctor doctor){
        if(doctor.getName()==null||doctor.getName().isEmpty()){
            throw new IncompleteDataException("El nombre del doctor no se ha ingresado");
        }
       return doctorRepository.save(doctor);
    }
    @Override
    public void delete(Long id){
        Doctor doctor = findById(id);
        doctorRepository.delete(doctor);
    }

    public Doctor findById(Long id) {
        Doctor doctorFound =doctorRepository.findById(id).orElse(null);
         if (doctorFound==null){
             throw new ResourceNotFoundException("No se encontró un doctor con este Id" +String.valueOf(id));
         }
         return doctorFound;
    }


}