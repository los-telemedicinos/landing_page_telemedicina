package pe.edu.upc.DocSeekerTP.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Patient;
    private String name;
    private String lastName;
    private Date bithdate;
    private String address;
    private int userId;
    private String email;
    private String phoneNumber;
    private String DNI;

    public Patient(){}

    public Patient(int id_Patient, String name, String lastName, Date bithdate, String address, int userId, String email, String phoneNumber, String DNI) {
        this.id_Patient = id_Patient;
        this.name = name;
        this.lastName = lastName;
        this.bithdate = bithdate;
        this.address = address;
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.DNI = DNI;
    }
}
