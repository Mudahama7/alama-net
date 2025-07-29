package referencedataguardian.controller.query;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import referencedataguardian.dto.StudentDto;
import referencedataguardian.service.contract.StudentService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/reference-data-guardian/students/")
public class StudentController {

    private StudentService studentService;

    @GetMapping("get-all")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

}
