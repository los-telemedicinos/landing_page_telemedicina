package pe.edu.upc.DocSeekerTP.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctor_times")
public class Doctor_Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date day;
    private String startTime;
    private String endTime;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

}
