package pe.edu.upc.DocSeekerTP.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String doctorDetails;
    private String email;
    private String dni;
    private int tuitionNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "doctor")
    private List<Doctor_Time> doctorTimes;

    @ManyToOne
    @JoinColumn(name="speciality_id")
    private Speciality speciality ;


    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

}
