package result_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import result_service.model.Promotion;

import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Optional<Promotion> findByExternalId(String externalId);

}
