package referencedataguardian.service.mapper;

import org.springframework.stereotype.Component;
import referencedataguardian.dto.TeacherDto;
import referencedataguardian.model.Teacher;

@Component
public class TeacherMapper {

    public TeacherDto mapFromEntityToDto(Teacher teacher) {
        return TeacherDto.builder()
                .email(teacher.getEmail())
                .level(teacher.getLevel())
                .name(teacher.getName())
                .first_name(teacher.getFirst_name())
                .registration_number(teacher.getRegistrationNumber())
                .surname(teacher.getSurname())
                .build();
    }

    public Teacher mapFromDtoRequestToEntity(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();

        teacher.setEmail(teacherDto.getEmail());
        teacher.setLevel(teacherDto.getLevel());
        teacher.setName(teacherDto.getName());
        teacher.setFirst_name(teacherDto.getFirst_name());
        teacher.setRegistrationNumber(teacherDto.getRegistration_number());
        teacher.setSurname(teacherDto.getSurname());

        return teacher;
    }

}
