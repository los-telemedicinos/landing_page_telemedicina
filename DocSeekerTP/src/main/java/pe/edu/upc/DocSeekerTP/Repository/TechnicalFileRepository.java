package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Technical_file;

public interface TechnicalFileRepository extends JpaRepository<Technical_file,Long> {
}
