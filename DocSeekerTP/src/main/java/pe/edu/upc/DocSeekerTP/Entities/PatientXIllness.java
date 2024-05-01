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

public class PatientXIllness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int Patient_Id_Patient;
    private String bloodType;
    private String privateMedicine;
    private int chronicIllnesses_id_Illness;

    public PatientXIllness(){}

    public PatientXIllness(int id, int patient_Id_Patient, String bloodType, String privateMedicine, int chronicIllnesses_id_Illness) {
        this.id = id;
        Patient_Id_Patient = patient_Id_Patient;
        this.bloodType = bloodType;
        this.privateMedicine = privateMedicine;
        this.chronicIllnesses_id_Illness = chronicIllnesses_id_Illness;
    }
}
