package result_service.service.contract;

import result_service.dto.request_objects.StudentReq;
import result_service.model.Student;

public interface StudentService {

    boolean saveStudent(StudentReq studentReq);

    Student findStudentByRegistration_number(String registration_number);

}
