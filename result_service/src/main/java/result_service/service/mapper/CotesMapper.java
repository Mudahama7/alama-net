package result_service.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.NewCoteRequest;
import result_service.model.Cotes;
import result_service.model.enums.Type_cote;
import result_service.service.contract.StudentService;
import result_service.service.contract.TeachingUnitElementService;

@AllArgsConstructor
@Service
public class CotesMapper {

    private StudentService studentService;
    private TeachingUnitElementService teachingUnitElementService;

    public Cotes mapFromRequestToCotes(NewCoteRequest coteRequest){
        Cotes cotes = new Cotes();

        cotes.setCote(coteRequest.getCote());
        cotes.setType_cote(Type_cote.valueOf(coteRequest.getType_cote()));
        cotes.setStudent(studentService.findStudentByRegistration_number(coteRequest.getStudentReq().getRegistration_number()));
        cotes.setTeachingUnit(teachingUnitElementService.findTeachingUnitElementByCode(coteRequest.getTeachingUnitElementReq().getCode()));

        return cotes;
    }

}
