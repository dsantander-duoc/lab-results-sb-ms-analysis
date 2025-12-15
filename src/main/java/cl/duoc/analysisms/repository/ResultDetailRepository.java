package cl.duoc.analysisms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.analysisms.entities.ResultDetail;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResultDetailRepository extends JpaRepository<ResultDetail, Long> {

    List<ResultDetail> findByAnalysisRequestId(Long analysisRequestId);

    List<ResultDetail> findByAnalysisTypeId(Long analysisTypeId);
}
