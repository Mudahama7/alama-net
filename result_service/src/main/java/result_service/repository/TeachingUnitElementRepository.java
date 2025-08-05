package result_service.repository;

import org.springframework.data.repository.CrudRepository;
import result_service.model.TeachingUnitElement;

import java.util.Optional;

public interface TeachingUnitElementRepository extends CrudRepository<TeachingUnitElement, Integer> {

    Optional<TeachingUnitElement> findByCode(String code);

}
