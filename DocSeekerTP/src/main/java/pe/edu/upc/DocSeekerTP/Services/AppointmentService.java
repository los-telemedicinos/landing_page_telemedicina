package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentSummary;
import pe.edu.upc.DocSeekerTP.entities.Appointment;

import java.util.List;

public interface AppointmentService {

    List<DTOAppointmentSummary> listAppointmentSummary();

    Appointment save(Appointment appointment);
}
