package cl.duoc.analysisms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.analysisms.entities.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByRut(String rut);
}
