package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
