package referencedataguardian.controller.query;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import referencedataguardian.dto.TeachingUnitElementDto;
import referencedataguardian.service.contract.TeachingUnitElementService;
import referencedataguardian.service.contract.TeachingUnitService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/reference-data-guardian/teaching-unit-element/")
public class TeachingUnitElement {

    private TeachingUnitElementService teachingUnitElementService;

    @GetMapping("get-all")
    public List<TeachingUnitElementDto> getAllTeachingUnitElements() {
        return teachingUnitElementService.getTeachingUnitElementsForOurSystem();
    }

}
