package referencedataguardian.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import referencedataguardian.dto.StudentDto;
import referencedataguardian.model.Student;
import referencedataguardian.service.PromotionService;

@AllArgsConstructor
@Component
public class StudentMapper {

    private final PromotionMapper promotionMapper;
    private final PromotionService promotionService;

    public StudentDto mapFromEntityToDtoResponse(Student student) {
        return StudentDto.builder()
                .address(student.getAddress())
                .name(student.getName())
                .email(student.getEmail())
                .surname(student.getSurname())
                .first_name(student.getFirst_name())
                .registration_number(student.getRegistration_number())
                .gender(student.getGender())
                .promotion(promotionMapper.mapFromEntityToDto(student.getPromotion()))
                .build();
    }

    public Student mapFromDtoRequestToEntity(StudentDto studentDto) {
        Student student = new Student();

        student.setAddress(studentDto.getAddress());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setSurname(studentDto.getSurname());
        student.setFirst_name(studentDto.getFirst_name());
        student.setRegistration_number(studentDto.getRegistration_number());
        student.setGender(studentDto.getGender());
        student.setPromotion(promotionService.getPromotionByExternalId(studentDto.getPromotion().getExternal_id()));

        return student;
    }

}
