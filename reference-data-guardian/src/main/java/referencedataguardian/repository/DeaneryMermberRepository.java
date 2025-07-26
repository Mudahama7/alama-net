package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.DeaneryMember;

public interface DeaneryMermberRepository extends JpaRepository<DeaneryMember, Integer> {
}
