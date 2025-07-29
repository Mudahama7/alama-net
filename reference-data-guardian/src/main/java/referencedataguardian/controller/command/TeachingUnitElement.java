package referencedataguardian.controller.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import referencedataguardian.dto.TeachingUnitElementDto;
import referencedataguardian.service.contact_external_services.FetchDataFromUniversityDB;
import referencedataguardian.service.contract.TeachingUnitElementService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/reference-data-guardian/teaching-unit-element/")
public class TeachingUnitElement {

    private TeachingUnitElementService teachingUnitElementService;
    private FetchDataFromUniversityDB fetchDataFromUniversityDB;

    @PostMapping("initialize-the-system/{url_api}")
    public boolean initializeTheSystem(@PathVariable String url_api) {
        List<TeachingUnitElementDto> listUEU = fetchDataFromUniversityDB.getAllUEU(url_api);
        return teachingUnitElementService.saveTeachingUnitElementsForOurSystem(listUEU);

    }

}
