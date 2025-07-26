package result_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import result_service.model.Cotes;

public interface CotesRepository extends JpaRepository<Cotes, Integer> {
}
