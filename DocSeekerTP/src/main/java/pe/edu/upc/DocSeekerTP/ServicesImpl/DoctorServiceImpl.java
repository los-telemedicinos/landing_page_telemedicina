package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.KeyRepeatedDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.DoctorRepository;
import pe.edu.upc.DocSeekerTP.Repository.SpecialityRepository;
import pe.edu.upc.DocSeekerTP.Services.DoctorService;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Patient;
import pe.edu.upc.DocSeekerTP.entities.Speciality;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    SpecialityRepository specialityRepository;

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
        // Verificar si se proporcionaron todos los datos necesarios
        if (doctor.getName() == null || doctor.getName().isEmpty() || doctor.getDni()==null||
            doctor.getDni().isEmpty()) {
            throw new IncompleteDataException("No se ha ingresado todos los datos");
        }

        // Verificar si el DNI ya existe en otro doctor
        List<Doctor> dniDoctorDuplicated = doctorRepository.findByDni(doctor.getDni());
        for (Doctor doc : dniDoctorDuplicated) {
            if(doctor.getDni().equals(doc.getDni())){
                throw new KeyRepeatedDataException("Este DNI ya se registró");
            }

        }
        // Verificar si el tuitionNumber ya existe en otro doctor
        List<Doctor> tuitionNumberDuplicated = doctorRepository.findBytuitionNumber(doctor.getTuitionNumber());
        for (Doctor doc : tuitionNumberDuplicated) {
            if(doctor.getTuitionNumber()== doc.getTuitionNumber()){
                throw new KeyRepeatedDataException("Este número de colegiatura ya se registró");
            }

        }

        // Verificar y asignar la especialidad existente
        Speciality speciality = doctor.getSpeciality();
        if (speciality != null) {
            Long specialityId = speciality.getId();
            if (specialityId == null) {
                throw new IncompleteDataException("ID de la especialidad no especificado");
            }

            Speciality existingSpeciality = specialityRepository.findById(specialityId)
                    .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));

            doctor.setSpeciality(existingSpeciality);
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