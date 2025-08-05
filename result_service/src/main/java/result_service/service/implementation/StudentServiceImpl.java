package result_service.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.request_objects.StudentReq;
import result_service.model.Student;
import result_service.repository.StudentRepository;
import result_service.service.contract.StudentService;
import result_service.service.mapper.StudentMapper;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public boolean saveStudent(StudentReq studentReq) {
        Student student = studentMapper.mapFromRequestToEntity(studentReq);
        studentRepository.save(student);
        return true;
    }

    @Override
    public Student findStudentByRegistration_number(String registration_number) {
        return studentRepository.findByRegistrationNumber(registration_number).orElse(null);
    }
}
