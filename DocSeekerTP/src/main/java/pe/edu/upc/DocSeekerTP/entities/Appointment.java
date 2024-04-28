package pe.edu.upc.DocSeekerTP.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
public class Appointment {
    private int id;
    private LocalDate appointmentDate;
    private String reason;
    private String state;
    private LocalDate registerDate_Appointment;
    private int Patient_id_Patient;
    private int prescription_id;
    private int Doctor_id_Doctor;
    public Appointment(){}

    public Appointment(int id, LocalDate appointmentDate, String reason, String state, LocalDate registerDate_Appointment, int patient_id_Patient, int prescription_id, int doctor_id_Doctor) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
        this.state = state;
        this.registerDate_Appointment = registerDate_Appointment;
        Patient_id_Patient = patient_id_Patient;
        this.prescription_id = prescription_id;
        Doctor_id_Doctor = doctor_id_Doctor;
    }

}
