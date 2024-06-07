package pe.edu.upc.DocSeekerTP.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate appointmentDate; // este fecha de cita no es los horarios del doctor?
    private String reason;
    private String state;
    private LocalDate registerDate_Appointment; //cambiar luego a un tipo date
    private Double temperature;
    private Double weight;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;



    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<Prescription> prescriptions;

    public Appointment(Long id, LocalDate appointmentDate, String reason, String state, LocalDate registerDate_Appointment, Double temperature, Double weight, Patient patient, Doctor doctor) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
        this.state = state;
        this.registerDate_Appointment = registerDate_Appointment;
        this.temperature = temperature;
        this.weight = weight;
        this.patient = patient;
        this.doctor = doctor;
    }
}