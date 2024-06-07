package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Dtos.DTOAppointmentSummary;
import pe.edu.upc.DocSeekerTP.Exceptions.ResourceNotFoundException;
import pe.edu.upc.DocSeekerTP.Repository.AppointmentRepository;
import pe.edu.upc.DocSeekerTP.Repository.DoctorRepository;
import pe.edu.upc.DocSeekerTP.Repository.PatientRepository;
import pe.edu.upc.DocSeekerTP.Services.AppointmentService;
import pe.edu.upc.DocSeekerTP.entities.Appointment;
import pe.edu.upc.DocSeekerTP.entities.Doctor;
import pe.edu.upc.DocSeekerTP.entities.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<DTOAppointmentSummary> listAppointmentSummary() {
        List<DTOAppointmentSummary> appointmentSummaryList = new ArrayList<>();

        for (Appointment appointment : appointmentRepository.findAll()) {
            String nameDoctor = appointment.getDoctor().getName();
            LocalDate date = LocalDate.parse(String.valueOf(appointment.getAppointmentDate()));
            String reason = appointment.getReason();
            String state = appointment.getState();
            DTOAppointmentSummary dtoAppointmentSummary = new DTOAppointmentSummary(nameDoctor, date, reason, state);
            appointmentSummaryList.add(dtoAppointmentSummary);
        }

        return appointmentSummaryList;
    }

    @Override
    public Appointment save(Appointment appointment) {
        // Verificar si el paciente y el doctor existen
        Long patientId = appointment.getPatient().getId();
        Long doctorId = appointment.getDoctor().getId();

        // Verificar que los IDs no sean nulos
        if (patientId == null || doctorId == null) {
            throw new ResourceNotFoundException("ID del paciente o del doctor no especificado en la cita");
        }

        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));

        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));

        // Asociar el paciente y el doctor a la cita
        appointment.setPatient(existingPatient);
        appointment.setDoctor(existingDoctor);

        // Guardar la cita
        return appointmentRepository.save(appointment);
    }

}