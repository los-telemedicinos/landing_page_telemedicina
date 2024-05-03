package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;

import java.util.List;

public interface DoctorTimeService {
    Doctor_Time save(Doctor_Time doctor_time);

    public void delete(Long id);
    public Doctor_Time findById(Long id);

    List<Doctor_Time> listAll();
}
