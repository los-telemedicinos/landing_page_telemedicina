package pe.edu.upc.DocSeekerTP.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Doctor {
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

    public Doctor(){}

    public Doctor(int id_Doctor, String name, String lastName, String speciality, String hospital, String doctorDetails, int user_Id, String email, String dni, int tuitionNumber) {
        this.id_Doctor = id_Doctor;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
        this.hospital = hospital;
        this.doctorDetails = doctorDetails;
        this.user_Id = user_Id;
        this.email = email;
        this.dni = dni;
        this.tuitionNumber = tuitionNumber;
    }

}
