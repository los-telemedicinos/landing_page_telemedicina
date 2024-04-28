package pe.edu.upc.DocSeekerTP.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@Setter
@Getter

public class Doctor_Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_time;
    private int Doctor_id_doctor;
    private LocalDate day;
    private String startTime;
    private String endTime;
    
    public Doctor_Time() {}

    public Doctor_Time(int id_time, int doctor_id_doctor, LocalDate day, String startTime, String endTime) {
        this.id_time = id_time;
        Doctor_id_doctor = doctor_id_doctor;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
