package pe.edu.upc.DocSeekerTP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.DocSeekerTP.entities.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
