package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Doctor_TimeDto {
    private int id_time;
    private int Doctor_id_doctor;
    private LocalDate day;
    private String startTime;
    private String endTime;
}
