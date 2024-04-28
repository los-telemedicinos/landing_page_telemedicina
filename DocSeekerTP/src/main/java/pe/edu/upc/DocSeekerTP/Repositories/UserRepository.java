package pe.edu.upc.DocSeekerTP.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserName(String userName);
}
