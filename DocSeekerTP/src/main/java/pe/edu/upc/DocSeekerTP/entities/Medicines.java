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
@Setter
@Getter

public class Medicines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Medicines;
    private String name_Medicines;

    public Medicines() {}

    public Medicines(int id_Medicines, String name_Medicines) {
        this.id_Medicines = id_Medicines;
        this.name_Medicines = name_Medicines;
    }
}
