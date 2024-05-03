package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.DoctorTimeRepository;
import pe.edu.upc.DocSeekerTP.Services.DoctorTimeService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;
import pe.edu.upc.DocSeekerTP.entities.Patient;

import java.util.List;

@Service
public class DoctorTimeServiceImpl implements DoctorTimeService {
    @Autowired
    DoctorTimeRepository doctorTimeRepository;

    @Override
    public Doctor_Time save(Doctor_Time doctor_time){
        if(doctor_time.getDay()==null){
            throw new IncompleteDataException("El nombre de la especialidad no se ha registrado");
        }
        return doctorTimeRepository.save(doctor_time);
    }
    @Override
    public void delete(Long id){
        Doctor_Time doctor_time = findById(id);
        doctorTimeRepository.delete(doctor_time);
    }

    public Doctor_Time findById(Long id) {
        Doctor_Time doctorTimeFound =doctorTimeRepository.findById(id).orElse(null);
        if (doctorTimeFound==null){
            throw new ResourceNotFoundException("No se encontro horario registrado" +String.valueOf(id));
        }
        return doctorTimeFound;
    }

    @Override
    public List<Doctor_Time> listAll() {
        List<Doctor_Time> doctorTimes = doctorTimeRepository.findAll();
        for (Doctor_Time e: doctorTimes) {
            e.setId(null);
        }
        return doctorTimes;
    }
}
