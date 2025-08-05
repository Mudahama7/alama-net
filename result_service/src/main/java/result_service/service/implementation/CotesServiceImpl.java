package result_service.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.NewCoteRequest;
import result_service.model.Cotes;
import result_service.repository.CotesRepository;
import result_service.service.contract.CotesService;
import result_service.service.contract.PromotionService;
import result_service.service.contract.StudentService;
import result_service.service.contract.TeachingUnitElementService;
import result_service.service.mapper.CotesMapper;

@AllArgsConstructor
@Service
public class CotesServiceImpl implements CotesService {

    private final CotesRepository cotesRepository;
    private final CotesMapper cotesMapper;
    private final PromotionService promotionService;
    private final StudentService studentService;
    private final TeachingUnitElementService teachingUnitElementService;

    @Override
    public boolean saveCotes(NewCoteRequest newCoteRequest) {

        promotionService.savePromotion(newCoteRequest.getPromotionReq());
        studentService.saveStudent(newCoteRequest.getStudentReq());
        teachingUnitElementService.saveTeachingUnitElement(newCoteRequest.getTeachingUnitElementReq());

        Cotes cotes = cotesMapper.mapFromRequestToCotes(newCoteRequest);
        cotesRepository.save(cotes);

        return true;
    }
}