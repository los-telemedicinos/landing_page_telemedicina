package pe.edu.upc.DocSeekerTP.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String details;


    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;


    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicines;

    public Prescription(Long id, String details) {
        this.id = id;
        this.details = details;
    }

    public void setMedicine(Medicine medicine) {
    }
}
