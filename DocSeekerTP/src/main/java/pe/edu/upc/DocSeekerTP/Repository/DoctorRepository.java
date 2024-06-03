package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Speciality;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}

