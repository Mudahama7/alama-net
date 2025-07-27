package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.StudentDto;
import referencedataguardian.model.Student;
import referencedataguardian.repository.StudentRepository;
import referencedataguardian.service.StudentService;
import referencedataguardian.service.mapper.StudentMapper;
import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    @Override
    public boolean saveStudentForInitializeOurSystem(List<StudentDto> listStudent) {
        List<Student> students = listStudent.stream()
                .map(studentDto -> studentMapper.mapFromDtoRequestToEntity(studentDto))
                .toList();

        studentRepository.saveAll(students);
        return true;
    }

}