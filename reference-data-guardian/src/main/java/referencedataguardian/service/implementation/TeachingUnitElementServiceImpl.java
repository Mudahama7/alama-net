package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.TeachingUnitElementDto;
import referencedataguardian.model.TeachingUnitElement;
import referencedataguardian.repository.TeachingUnitElementRepository;
import referencedataguardian.service.contract.TeachingUnitElementService;
import referencedataguardian.service.mapper.TeachingUnitElementMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class TeachingUnitElementServiceImpl implements TeachingUnitElementService {

    private TeachingUnitElementRepository teachingUnitElementRepository;
    private TeachingUnitElementMapper teachingUnitElementMapper;

    @Override
    public boolean saveTeachingUnitElementsForOurSystem(List<TeachingUnitElementDto> teachingUnitElements) {
        List<TeachingUnitElement> teachingUnitElementList = teachingUnitElements.stream()
                .map(teachingUnitElementMapper::mapFromDtoRequestToEntity)
                .toList();

        teachingUnitElementRepository.saveAll(teachingUnitElementList);

        return true;
    }

    @Override
    public List<TeachingUnitElementDto> getTeachingUnitElementsForOurSystem() {
        return teachingUnitElementRepository.findAll().stream()
                .map(teachingUnitElementMapper::mapFromEntityToDto)
                .toList();
    }
}
