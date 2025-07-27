package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.TeachingUnit;

import java.util.Optional;

public interface TeachingUnitRepository extends JpaRepository<TeachingUnit, Integer> {

    Optional<TeachingUnit> findByCode(String code);

}