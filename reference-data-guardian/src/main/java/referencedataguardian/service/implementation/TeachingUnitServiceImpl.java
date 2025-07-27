package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.TeachingUnitDto;
import referencedataguardian.model.TeachingUnit;
import referencedataguardian.repository.TeachingUnitRepository;
import referencedataguardian.service.TeachingUnitService;
import referencedataguardian.service.mapper.TeachingUnitMapper;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TeachingUnitServiceImpl implements TeachingUnitService {

    private TeachingUnitRepository teachingUnitRepository;
    private TeachingUnitMapper teachingUnitMapper;

    @Override
    public boolean saveTeachinUnitsForInitializeOurSystem(List<TeachingUnitDto> teachingUnits) {
        List<TeachingUnit> newTeachingUnits = teachingUnits.stream()
                .map(teachingUnitMapper::mapFromDtoRequestToEntity)
                .toList();
        teachingUnitRepository.saveAll(newTeachingUnits);
        return true;
    }

    @Override
    public TeachingUnit findByCode(String code) {
        return teachingUnitRepository.findByCode(code).orElse(null);
    }
}
