package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
