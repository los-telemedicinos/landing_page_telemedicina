package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class DTOAppointmentSummary {

    private String nameDoctor;
    private LocalDate appointmentDate;
    private String reason;
    private String state;
}
