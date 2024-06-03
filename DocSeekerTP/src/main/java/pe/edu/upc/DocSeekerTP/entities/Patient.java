package pe.edu.upc.DocSeekerTP.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String address;
    private String email;
    private String phoneNumber;
    private String dni;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToOne(mappedBy = "patient")
    private Technical_file technical_file;

    public Patient(Long id, String name, String lastName, LocalDate birthdate, String address, String email, String phoneNumber, String dni) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dni = dni;
    }
}