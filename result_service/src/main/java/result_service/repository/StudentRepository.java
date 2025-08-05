package result_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import result_service.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByRegistrationNumber(String registrationNumber);

}