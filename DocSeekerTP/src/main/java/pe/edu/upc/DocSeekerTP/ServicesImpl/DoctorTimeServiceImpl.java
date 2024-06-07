package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.DoctorRepository;
import pe.edu.upc.DocSeekerTP.Repository.DoctorTimeRepository;
import pe.edu.upc.DocSeekerTP.Services.DoctorTimeService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DoctorTimeServiceImpl implements DoctorTimeService {
    @Autowired
    DoctorTimeRepository doctorTimeRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor_Time save(Doctor_Time doctor_time) {
        if (doctor_time.getDay() == null || doctor_time.getDoctor() == null) {
            throw new IncompleteDataException("Falta información para crear el horario.");
        }
        // Asignar el doctor al Doctor_Time si no está asignado
        if (doctor_time.getDoctor().getId() == null) {
            throw new IncompleteDataException("Se necesita especificar el ID del doctor");
        }
        Doctor existingDoctor = doctorRepository.findById(doctor_time.getDoctor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor no encontrado con ID: " + doctor_time.getDoctor().getId()));
        doctor_time.setDoctor(existingDoctor);

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
