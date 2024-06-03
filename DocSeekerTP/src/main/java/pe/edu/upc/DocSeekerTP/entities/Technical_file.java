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
@Table(name = "tecnical_file")
public class Technical_file {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean asthma;
    private boolean diabetes;
    private boolean arthritis;
    private boolean hypertension;
    private boolean depression;
    private boolean highCholesterol;
    private boolean gynecologicalProblems;
    private boolean osteoporosis;
    private boolean cardiovascular;
    private String others;
    private String bloodType;
    private String privateMedicine;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
