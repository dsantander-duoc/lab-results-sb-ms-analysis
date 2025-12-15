package cl.duoc.analysisms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.analysisms.entities.Laboratory;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

}
