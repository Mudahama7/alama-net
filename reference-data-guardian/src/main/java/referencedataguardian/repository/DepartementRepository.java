package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
