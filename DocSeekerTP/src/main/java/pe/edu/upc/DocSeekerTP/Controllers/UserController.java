package pe.edu.upc.DocSeekerTP.Controllers;

import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Entities.User;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll(){
        List<User> list_User = new ArrayList<>();
        User user = new User();
        user.setUserName("Manuel");
        user.setPassword("12345678holas");
        user.setEnable(true);
        list_User.add(user);
        return list_User;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable long id){
        User user = new User();
        user.setUserName("Manuel");
        user.setPassword("12345678holas");
        user.setEnable(true);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    User register(@RequestBody User user){
        // Registrar en la base de datos
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@RequestBody User user){
        // Actualizar en la base de datos
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void push(@PathVariable long id){
        // Eliminar en la base de datos
    }
}
