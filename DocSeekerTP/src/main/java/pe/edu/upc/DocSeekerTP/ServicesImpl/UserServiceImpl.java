package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Dtos.DTOUser;
import pe.edu.upc.DocSeekerTP.Exceptions.IncompleteDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.KeyRepeatedDataException;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.AuthorityRepository;
import pe.edu.upc.DocSeekerTP.Repository.UserRepository;
import pe.edu.upc.DocSeekerTP.Services.UserService;
import pe.edu.upc.DocSeekerTP.entities.AuthorityName;
import pe.edu.upc.DocSeekerTP.entities.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public User findById(Long id) {

      User userFound = userRepository.findById(id).orElse(null);
        if (userFound == null) {
            throw new ResourceNotFoundException("There are no User with the id: "+String.valueOf(id));
        }
        return userFound;
    }

    @Override
    public User register(DTOUser user) {

        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getUserName());
            if (userFound != null) {
                throw new KeyRepeatedDataException("User name can not be duplicated");
            };

            User newUser = new User();
            newUser.setUserName(user.getUserName());
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            newUser.setEnable(true);
            AuthorityName authorityName=AuthorityName.ROLE_PATIENT;
            if (user.getType().equals("ROLE_PATIENT")) authorityName= AuthorityName.ROLE_PATIENT;
            if (user.getType().equals("ROLE_ADMIN")) authorityName= AuthorityName.ROLE_ADMIN;
            newUser.setAuthorities(
                    List.of(
                            authorityRepository.findByName(authorityName)
                    )
            );

            return userRepository.save(newUser);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public User changePassword(DTOUser user) {
        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getUserName());
            if (userFound == null) {
                throw new ResourceNotFoundException("User name can not be found");
            };

            userFound.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return userRepository.save(userFound);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }
}

