package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;

public interface DoctorTimeRepository extends JpaRepository<Doctor_Time, Long> {

}
