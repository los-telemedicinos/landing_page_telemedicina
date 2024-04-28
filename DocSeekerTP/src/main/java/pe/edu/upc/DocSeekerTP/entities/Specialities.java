package pe.edu.upc.DocSeekerTP.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter

public class Specialities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_speciality;
    private String speciality_name;

    public Specialities() {}

    public Specialities(int id_speciality, String speciality_name) {
        this.id_speciality = id_speciality;
        this.speciality_name = speciality_name;
    }
}
