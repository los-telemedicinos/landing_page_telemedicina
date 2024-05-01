package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserName(String userName);
}
