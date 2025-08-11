package result_service.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import result_service.dto.ResultBulletinContent;
import result_service.dto.ResultBulletinLine;
import result_service.dto.StudentInfosForResult;
import result_service.model.Student;
import result_service.service.contract.AverageInTUEService;
import result_service.service.contract.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class ResultBulletinBuilder {

    private final AverageInTUEService averageInTUEService;
    private final StudentService studentService;

    public List<ResultBulletinContent> buildingResultBulletinByCalculateDifferentAveragesForAPromotion(List<Student> promotionStudents) {
        List<ResultBulletinContent> resultBulletinContents = new ArrayList<>();

        for (Student student : promotionStudents) {

            Map<StudentInfosForResult, List<ResultBulletinLine>> map = new HashMap<>();
            map.put(
                    provideStudentInfosForResult(student),
                    averageInTUEService.calculateStudentAverage(student.getCotes())
            );

            ResultBulletinContent content = ResultBulletinContent.builder()
                    .studentResultBulletinLines(map)
                    .build();

            resultBulletinContents.add(content);
        }

        return resultBulletinContents;
    }

    private StudentInfosForResult provideStudentInfosForResult(Student student) {

        String fullName = String.join(" ", student.getName(), student.getSurname(), student.getFirst_name());
        return StudentInfosForResult.builder()
                .student_full_name(fullName)
                .student_registration_number(student.getRegistrationNumber())
                .build();
    }

    public ResultBulletinContent buildingResultBulletinByCalculateDifferentAveragesForAStudent(String student_registration_number){

        Student student = studentService.findStudentByRegistration_number(student_registration_number);

        Map<StudentInfosForResult, List<ResultBulletinLine>> map = new HashMap<>();
        map.put(
                provideStudentInfosForResult(student),
                averageInTUEService.calculateStudentAverage(student.getCotes())
        );

        return ResultBulletinContent.builder()
                .studentResultBulletinLines(map)
                .build();
    }

}