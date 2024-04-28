package pe.edu.upc.DocSeekerTP.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PatientXIllness {
    private int id;
    private int Patient_Id_Patient;
    private String bloodType;
    private String privateMedicine;
    private int chronicIllnesses_id_Illness;
}
