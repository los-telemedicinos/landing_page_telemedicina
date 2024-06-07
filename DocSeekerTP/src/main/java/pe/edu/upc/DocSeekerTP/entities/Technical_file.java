package pe.edu.upc.DocSeekerTP.entities;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String allergyToMedication;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnoreProperties({"name", "lastName", "birthdate", "address", "email", "phoneNumber", "dni"})
    private Patient patient;

}
