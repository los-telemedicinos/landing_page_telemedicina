package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
