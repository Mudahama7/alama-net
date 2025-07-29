package referencedataguardian.service.contract;

import referencedataguardian.dto.TeacherDto;
import referencedataguardian.model.Teacher;

import java.util.List;

public interface TeacherService {

    boolean saveTeachersForInitializeOurSystem(List<TeacherDto> teachers);

    Teacher findByEmail(String email);

    List<TeacherDto> findAllTeachers();

}
