package pe.edu.upc.DocSeekerTP.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DTOAppointmentSummary {

    private String nameDoctor;
    private String date;
    private String reason;
    private String state;
}
