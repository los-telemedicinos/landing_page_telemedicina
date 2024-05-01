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
@Table(name="specialities")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int id_speciality;
    private String speciality_name;

    @JsonIgnore
    @OneToMany(mappedBy = "speciality")
    private List<Doctor> doctors;
}
