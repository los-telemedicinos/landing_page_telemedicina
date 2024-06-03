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

    private String specialityName;

    @JsonIgnore
    @OneToMany(mappedBy = "speciality")
    private List<Doctor> doctors;

    public Speciality(Long id, String specialityName) {
        this.id = id;
        this.specialityName = specialityName;
    }
}
