package pe.edu.upc.DocSeekerTP.entities;

import java.time.LocalDate;
import java.util.Date;

public class Appointment {
    private int id;
    private LocalDate appointmentDate;
    private String reason;
    private String state;
    private Date registerDate_Appointment;
    private int Patient_id_Patient;
    private int prescription_id;
    private int Doctor_id_Doctor;
    public Appointment(){}

    public Appointment(int id, LocalDate appointmentDate, String reason, String state, Date registerDate_Appointment, int patient_id_Patient, int prescription_id, int doctor_id_Doctor) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
        this.state = state;
        this.registerDate_Appointment = registerDate_Appointment;
        Patient_id_Patient = patient_id_Patient;
        this.prescription_id = prescription_id;
        Doctor_id_Doctor = doctor_id_Doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getRegisterDate_Appointment() {
        return registerDate_Appointment;
    }

    public void setRegisterDate_Appointment(Date registerDate_Appointment) {
        this.registerDate_Appointment = registerDate_Appointment;
    }

    public int getPatient_id_Patient() {
        return Patient_id_Patient;
    }

    public void setPatient_id_Patient(int patient_id_Patient) {
        Patient_id_Patient = patient_id_Patient;
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public int getDoctor_id_Doctor() {
        return Doctor_id_Doctor;
    }

    public void setDoctor_id_Doctor(int doctor_id_Doctor) {
        Doctor_id_Doctor = doctor_id_Doctor;
    }
}
