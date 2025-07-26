package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.TeachingUnit;

public interface TeachingUnitRepository extends JpaRepository<TeachingUnit, Integer> {
}
