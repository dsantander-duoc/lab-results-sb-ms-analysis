package cl.duoc.analysisms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.analysisms.entities.AnalysisType;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisTypeRepository extends JpaRepository<AnalysisType, Long> {
    AnalysisType findByName(String name);
}
