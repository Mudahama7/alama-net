package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.TeacherDto;
import referencedataguardian.model.Teacher;
import referencedataguardian.repository.TeacherRepository;
import referencedataguardian.service.TeacherService;
import referencedataguardian.service.mapper.TeacherMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private TeacherMapper teacherMapper;

    @Override
    public boolean saveTeachersForInitializeOurSystem(List<TeacherDto> teachers) {
        List<Teacher> teacherList = teachers.stream()
                .map(teacherMapper::mapFromDtoRequestToEntity)
                .toList();

        teacherRepository.saveAll(teacherList);

        return true;
    }

    @Override
    public Teacher findByEmail(String email) {
        return teacherRepository.findByEmail(email).orElse(null);
    }
}
