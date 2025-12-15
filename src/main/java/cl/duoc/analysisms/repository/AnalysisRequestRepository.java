package cl.duoc.analysisms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.analysisms.entities.AnalysisRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRequestRepository extends JpaRepository<AnalysisRequest, Long> {
    List<AnalysisRequest> findByPatientId(Long patientId);

    List<AnalysisRequest> findByLaboratoryId(Long laboratoryId);

    List<AnalysisRequest> findByUserId(Long userId);
}
