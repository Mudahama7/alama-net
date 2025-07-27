package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.Departement;

import java.util.Optional;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    Optional<Departement> findByExternalId(String externalId);
}
