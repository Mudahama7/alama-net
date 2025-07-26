package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {
}
