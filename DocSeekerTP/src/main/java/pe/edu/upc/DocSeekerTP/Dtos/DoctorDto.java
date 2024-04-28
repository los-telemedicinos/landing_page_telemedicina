package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class DoctorDto {
    private int id_Doctor;
    private String name;
    private String lastName;
    private String speciality;
    private String hospital;
    private String doctorDetails;
    private int user_Id;
    private String email;
    private String dni;
    private int tuitionNumber;
}
