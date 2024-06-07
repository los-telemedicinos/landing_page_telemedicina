package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Doctor_Time;

import java.util.List;

public interface DoctorTimeRepository extends JpaRepository<Doctor_Time, Long> {

}
