package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PatientXIllnessDto {
    private int id;
    private String Patient_Id_Patient;
    private String bloodType;
    private String privateMedicine;
    private int chronicIllnesses_id_Illness;
}
