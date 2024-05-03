package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentSummary;
import pe.edu.upc.DocSeekerTP.Repository.AppointmentRepository;
import pe.edu.upc.DocSeekerTP.Services.AppointmentService;
import pe.edu.upc.DocSeekerTP.entities.Appointment;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

   @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<DTOAppointmentSummary> listAppointmentSummary() {
        List<DTOAppointmentSummary> appointmentSummaryList = new ArrayList<>();

        for (Appointment appointment : appointmentRepository.findAll()) {
            String nameDoctor = appointment.getDoctor().getName();
            String date = appointment.getAppointmentDate();
            String reason = appointment.getReason();
            String state = appointment.getState();

            DTOAppointmentSummary dtoAppointmentSummary = new DTOAppointmentSummary(nameDoctor, date, reason, state);
            appointmentSummaryList.add(dtoAppointmentSummary);
        }

        return appointmentSummaryList;
    }
}

