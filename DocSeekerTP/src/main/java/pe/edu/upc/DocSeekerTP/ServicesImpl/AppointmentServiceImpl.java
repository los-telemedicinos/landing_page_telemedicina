package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentCreate;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentSummary;
import pe.edu.upc.DocSeekerTP.Repository.AppointmentRepository;
import pe.edu.upc.DocSeekerTP.Repository.DoctorRepository;
import pe.edu.upc.DocSeekerTP.Services.AppointmentService;
import pe.edu.upc.DocSeekerTP.entities.Appointment;
import pe.edu.upc.DocSeekerTP.entities.Doctor;

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
            String date = String.valueOf(appointment.getAppointmentDate());
            String reason = appointment.getReason();
            String state = appointment.getState();

            DTOAppointmentSummary dtoAppointmentSummary = new DTOAppointmentSummary(nameDoctor, date, reason, state);
            appointmentSummaryList.add(dtoAppointmentSummary);
        }

        return appointmentSummaryList;
    }

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Appointment createAppointment(DTOAppointmentCreate requestDTO) {
        // Verificar si el doctor existe
        Doctor doctor = doctorRepository.findById(requestDTO.getDoctorId())
                .orElseThrow(() -> new NotFoundException("Doctor not found with ID: " + requestDTO.getDoctorId()));

        // Crear el Appointment
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(requestDTO.getAppointmentDate());
        appointment.setReason(requestDTO.getReason());
        appointment.setTemperature(requestDTO.getTemperature());
        appointment.setWeight(requestDTO.getWeight());
        appointment.setState("Pendiente");

        // Guardar el Appointment
        return appointmentRepository.save(appointment);
    }
}

