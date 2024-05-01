package pe.edu.upc.DocSeekerTP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.edu.upc.DocSeekerTP.Repository.AuthorityRepository;
import pe.edu.upc.DocSeekerTP.Repository.DoctorRepository;
import pe.edu.upc.DocSeekerTP.Repository.UserRepository;
import pe.edu.upc.DocSeekerTP.entities.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DocSeekerTpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocSeekerTpApplication.class, args);
	}
	@Bean
	public CommandLineRunner mappingDemo(
			UserRepository userRepository,
			DoctorRepository doctorRepository,
			AuthorityRepository authorityRepository
	){
		return args -> {
			authorityRepository.save(new Authority(AuthorityName.ROLE_PATIENT));
			authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
			userRepository.save(
					new User("Maria", new BCryptPasswordEncoder().encode("mariaPrueba"),true, new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PATIENT)
							)
					)
			);
			userRepository.save(
					new User ("Luis", new BCryptPasswordEncoder().encode("ruizluis"),true, new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_ADMIN)
							)
					)
			);
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Doctor doctor1= doctorRepository.save(new Doctor(Long.valueOf(0),"Marcos", "Jimenez Ruiz",
					"20 años de experiencia","ruiz@gmail.com", "75707505", 234, null,null,null ));
		};
	}

}
