package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Prescription;

public interface PrescriptionRepository extends JpaRepository <Prescription, Long> {

}
