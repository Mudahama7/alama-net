package referencedataguardian.service;
import referencedataguardian.dto.StudentDto;

import java.util.List;

public interface StudentService {

    boolean saveStudentForInitializeOurSystem(List<StudentDto> listStudent);

}
