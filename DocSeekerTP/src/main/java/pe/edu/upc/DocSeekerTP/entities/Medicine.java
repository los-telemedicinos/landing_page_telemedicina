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
@Table(name="medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_Medicines;

    @JsonIgnore
    @OneToMany(mappedBy = "medicines")
    private List<Prescription> prescriptions;

    public Medicine(Long id, String name_Medicines) {
        this.id = id;
        this.name_Medicines = name_Medicines;
    }
}
