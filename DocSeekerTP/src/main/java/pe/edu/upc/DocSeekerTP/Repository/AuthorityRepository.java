package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Authority;
import pe.edu.upc.DocSeekerTP.entities.AuthorityName;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Authority findByName(AuthorityName name);
}
