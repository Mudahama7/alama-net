package result_service.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.request_objects.TeachingUnitElementReq;
import result_service.model.TeachingUnitElement;
import result_service.repository.TeachingUnitElementRepository;
import result_service.service.contract.TeachingUnitElementService;
import result_service.service.mapper.TeachingUnitElementMapper;

@AllArgsConstructor
@Service
public class TeachingUnitElementServiceImpl implements TeachingUnitElementService {

    private final TeachingUnitElementRepository teachingUnitElementRepository;
    private final TeachingUnitElementMapper teachingUnitElementMapper;


    @Override
    public boolean saveTeachingUnitElement(TeachingUnitElementReq teachingUnitElementReq) {
        TeachingUnitElement teachingUnitElement = teachingUnitElementMapper.mapFromDtoToEntity(teachingUnitElementReq);
        teachingUnitElementRepository.save(teachingUnitElement);

        return true;
    }

    @Override
    public TeachingUnitElement findTeachingUnitElementByCode(String code) {
        return teachingUnitElementRepository.findByCode(code).orElse(null);
    }
}
