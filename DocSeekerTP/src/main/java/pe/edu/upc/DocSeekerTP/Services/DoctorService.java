package pe.edu.upc.DocSeekerTP.Services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Entities.Doctor;
import pe.edu.upc.DocSeekerTP.Repositories.DoctorRepository;

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;


    @Transactional

    //insertar
    public Doctor insertar (Doctor doctor) {
        return doctorRepository.save(doctor);
    }

}
