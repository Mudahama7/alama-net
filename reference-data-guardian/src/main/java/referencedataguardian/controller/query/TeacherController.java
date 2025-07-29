package referencedataguardian.controller.query;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import referencedataguardian.dto.TeacherDto;
import referencedataguardian.service.contract.TeacherService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/reference-data-guardian/teachers/")
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping("get-all")
    public List<TeacherDto> getAllTeachers() {
        return teacherService.findAllTeachers();
    }

}
