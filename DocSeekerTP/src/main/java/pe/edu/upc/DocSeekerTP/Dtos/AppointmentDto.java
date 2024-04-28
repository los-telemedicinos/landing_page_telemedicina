package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AppointmentDto {
    private int id;
    private LocalDate appointmentDate;
    private String reason;
    private String state;
    private LocalDate registerDate_Appointment;
    private int Patient_id_Patient;
    private int prescription_id;
    private int Doctor_id_Doctor;
}
