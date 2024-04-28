package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PatientDto {
    private int id_Patient;
    private String name;
    private String lastName;
    private Date bithdate;
    private String address;
    private int userId;
    private String email;
    private String phoneNumber;
    private String DNI;
}
