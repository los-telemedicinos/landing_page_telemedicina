package pe.edu.upc.DocSeekerTP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.DocSeekerTP.Dtos.DTOToken;
import pe.edu.upc.DocSeekerTP.Dtos.DTOUser;
import pe.edu.upc.DocSeekerTP.Services.UserService;
import pe.edu.upc.DocSeekerTP.entities.User;
import pe.edu.upc.DocSeekerTP.security.JwtUtilService;
import pe.edu.upc.DocSeekerTP.security.SecurityUser;

import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {


        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        UserDetailsService userDetailsService;

        @Autowired
        private JwtUtilService jwtUtilService;

        @Autowired
        UserService userService;

        @PostMapping("/users/register")
        public ResponseEntity<User> createUser(@RequestBody DTOUser user) {
            User newUser = userService.register(user);
            return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
        }


        @PutMapping("/users")
        public ResponseEntity<User> updateUser(@RequestBody DTOUser user) {
            User newUser = userService.changePassword(user);
            return new ResponseEntity<User>(newUser, HttpStatus.OK);
        }


        @GetMapping("/users/{id}")
        public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
            User user = userService.findById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }


        @PostMapping("/users/login")
        public ResponseEntity<DTOToken> authenticate(@RequestBody DTOUser user) {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(),
                            user.getPassword()));
            SecurityUser securityUser = (SecurityUser) this.userDetailsService.loadUserByUsername(
                    user.getUserName());
            String jwt = jwtUtilService.generateToken(securityUser);
            Long id = securityUser.getUser().getId();

            String authoritiesString = securityUser.getUser().getAuthorities().stream()
                    .map(n -> String.valueOf(n.getName().toString()))
                    .collect(Collectors.joining(";", "", ""));
            System.out.println(authoritiesString);
            return new ResponseEntity<DTOToken>(new DTOToken(jwt, id, authoritiesString), HttpStatus.OK);

        }


}