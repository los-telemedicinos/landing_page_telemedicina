package pe.edu.upc.DocSeekerTP.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String appointmentDate;
    private String reason;
    private String state;
    private Date registerDate_Appointment; //cambiar luego a un tipo date
    private Double temperature;
    private Double weight;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @JsonIgnore
    @OneToMany(mappedBy = "appointment")
    private List<Prescription> prescriptions;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "register_date_appointment")
    private Date getRegisterDate_Appointment() {
        return registerDate_Appointment;
    }

    @PrePersist
    protected void onCreate() {
        registerDate_Appointment = new Date();
    }

}