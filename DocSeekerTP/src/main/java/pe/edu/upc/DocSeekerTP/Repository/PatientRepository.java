package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.DocSeekerTP.entities.Patient;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    @Query("SELECT p FROM Patient p INNER JOIN Appointment ap ON p.id = ap.patient.id WHERE ap.appointmentDate = :fecha")
    List<Patient> findByAppointmentDate(@Param("fecha") Date fecha);

    List<Patient> findAllByDni(String dni);
}
