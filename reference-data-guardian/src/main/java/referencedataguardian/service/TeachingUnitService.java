package referencedataguardian.service;

import referencedataguardian.dto.TeachingUnitDto;
import referencedataguardian.model.TeachingUnit;

import java.util.List;

public interface TeachingUnitService {

    boolean saveTeachinUnitsForInitializeOurSystem(List<TeachingUnitDto> teachingUnits);

    TeachingUnit findByCode(String code);

}
