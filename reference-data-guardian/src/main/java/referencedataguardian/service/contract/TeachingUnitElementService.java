package referencedataguardian.service.contract;

import referencedataguardian.dto.TeachingUnitElementDto;

import java.util.List;

public interface TeachingUnitElementService {

    boolean saveTeachingUnitElementsForOurSystem(List<TeachingUnitElementDto> teachingUnitElements);

    List<TeachingUnitElementDto> getTeachingUnitElementsForOurSystem();

}
