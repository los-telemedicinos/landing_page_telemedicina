package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class DTOAppointmentCreate {
    @Getter
    private Long doctorId;
    private String appointmentDate;
    private String reason;
    private Double temperature;
    private Double weight;

}
