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

public class ChronicIllness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Illness;
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

    public ChronicIllness(){}

    public ChronicIllness(int id_Illness, boolean asthma, boolean diabetes, boolean arthritis, boolean hypertension, boolean depression, boolean highCholesterol, boolean gynecologicalProblems, boolean osteoporosis, boolean cardiovascular, String others) {
        this.id_Illness = id_Illness;
        this.asthma = asthma;
        this.diabetes = diabetes;
        this.arthritis = arthritis;
        this.hypertension = hypertension;
        this.depression = depression;
        this.highCholesterol = highCholesterol;
        this.gynecologicalProblems = gynecologicalProblems;
        this.osteoporosis = osteoporosis;
        this.cardiovascular = cardiovascular;
        this.others = others;
    }
}
