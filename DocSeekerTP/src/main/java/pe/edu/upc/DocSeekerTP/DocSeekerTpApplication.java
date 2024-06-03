package pe.edu.upc.DocSeekerTP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pe.edu.upc.DocSeekerTP.Repository.*;
import pe.edu.upc.DocSeekerTP.Services.PrescriptionService;
import pe.edu.upc.DocSeekerTP.entities.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
			DoctorTimeRepository doctorTimeRepository,
			DoctorRepository doctorRepository,
			AuthorityRepository authorityRepository,
			SpecialityRepository specialityRepository,
			PatientRepository patientRepository,
			TechnicalFileRepository technicalFileRepository

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

			Speciality speciality1 = specialityRepository.save(new Speciality(0L,"Cardiologia"));
			Speciality speciality2 = specialityRepository.save(new Speciality(0L,"Dermatologia"));
			Speciality speciality3 = specialityRepository.save(new Speciality(0L,"Ginecologia"));
			Speciality speciality4 = specialityRepository.save(new Speciality(0L,"Pediatria"));

			Doctor doctor1= doctorRepository.save(new Doctor(0L,"Marcos", "Jimenez Ruiz", "20 años de experiencia","ruiz@gmail.com", "75707505", 567432234, null,speciality1, null ));
			Doctor doctor2= doctorRepository.save(new Doctor(0L,"Hebert", "Bances Rios", "especialista en trato con el paciente","hebertbances@gmail.com", "75707213", 234987657, null,speciality2, null ));

			Doctor_Time doctor_time1Save =doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,16), "08:00","08:30",doctor1));
			doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,16), "08:30","09:00",doctor1));
			doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,17), "09:00","09:30",doctor1));
			doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,17), "10:00","10:30",doctor1));
			doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,16), "08:00","08:30",doctor2));
			doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,16), "08:30","09:00",doctor2));
			doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,18), "17:30","18:00",doctor2));
			doctorTimeRepository.save(new Doctor_Time(0L, LocalDate.of(2024,5,18), "18:10","18:40",doctor2));

			Patient patient1 = patientRepository.save(new Patient(0L,"Maria","Cifuentes Cegarra", LocalDate.of(2001,2,12),"Villa Maria del triunfo","Maria1@gmail.com","931678902","76750781"));
			Patient patient2 =patientRepository.save(new Patient(0L,"Lucia","Arevalo Mendoza", LocalDate.of(1998,8,22),"San Miguel","avendañoalvarez@gmail.com","923678950","67894509"));

			Technical_file technicalFileSave = technicalFileRepository.save(new Technical_file(0L,true,false,false,false,true,false,false,false,false,"","A positivo","Penicilina",patient1));

		};



	}

}
