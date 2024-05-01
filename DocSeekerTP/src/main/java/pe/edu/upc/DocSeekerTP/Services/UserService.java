package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.Dtos.DTOUser;
import pe.edu.upc.DocSeekerTP.entities.User;

public interface UserService {
    public User findById(Long id);

    public User register(DTOUser user);

    public User changePassword(DTOUser user);

}
