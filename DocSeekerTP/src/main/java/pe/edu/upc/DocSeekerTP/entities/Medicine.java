package pe.edu.upc.DocSeekerTP.entities;

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

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions;
}
