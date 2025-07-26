package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
