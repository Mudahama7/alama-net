package referencedataguardian.controller.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import referencedataguardian.dto.StudentDto;
import referencedataguardian.service.contact_external_services.FetchDataFromUniversityDB;
import referencedataguardian.service.contract.StudentService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/reference-data-guardian/students/")
public class StudentController {

    private StudentService studentService;
    private FetchDataFromUniversityDB fetchDataFromUniversityDB;

    @PostMapping("initialize-the-system/{url_api}")
    public boolean initializeTheSystemTeachers(@PathVariable String url_api) {
        List<StudentDto> studentDtos = fetchDataFromUniversityDB.getAllStudent(url_api);

        return studentService.saveStudentForInitializeOurSystem(studentDtos);
    }

}
