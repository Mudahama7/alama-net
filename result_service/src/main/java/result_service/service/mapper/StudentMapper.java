package result_service.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.request_objects.StudentReq;
import result_service.model.Student;
import result_service.service.contract.PromotionService;

@AllArgsConstructor
@Service
public class StudentMapper {

    private final PromotionService promotionService;

    public Student mapFromRequestToEntity(StudentReq studentReq) {
        Student student = new Student();

        student.setName(studentReq.getName());
        student.setSurname(studentReq.getSurname());
        student.setEmail(studentReq.getEmail());
        student.setFirst_name(studentReq.getFirst_name());
        student.setRegistrationNumber(studentReq.getRegistration_number());
        student.setPromotion(promotionService.findPromotionByExternal_id(studentReq.getPromotion_external_id()));

        return student;
    }

}
