package pe.edu.upc.DocSeekerTP.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private Date bithdate;
    private String address;
    private String email;
    private String phoneNumber;
    private String DNI;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @JsonIgnore
    @OneToMany(mappedBy = "patient")
    private List<ChronicXDisease> chronicXDiseases;

}