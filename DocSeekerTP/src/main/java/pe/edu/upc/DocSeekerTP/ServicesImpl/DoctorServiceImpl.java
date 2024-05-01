package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Repository.DoctorRepository;
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
}