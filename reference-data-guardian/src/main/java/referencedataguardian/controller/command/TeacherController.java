package referencedataguardian.controller.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import referencedataguardian.dto.TeacherDto;
import referencedataguardian.service.contact_external_services.FetchDataFromUniversityDB;
import referencedataguardian.service.contract.TeacherService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/reference-data-guardian/teachers/")
public class TeacherController {

    private TeacherService teacherService;
    private FetchDataFromUniversityDB fetchDataFromUniversityDB;

    @PostMapping("initialize-the-system/{url_api}")
    public boolean initializeTheSystemTeachers(@PathVariable String url_api) {
        List<TeacherDto> teacherDtoList = fetchDataFromUniversityDB.getAllTeachers(url_api);

        return teacherService.saveTeachersForInitializeOurSystem(teacherDtoList);
    }


}
