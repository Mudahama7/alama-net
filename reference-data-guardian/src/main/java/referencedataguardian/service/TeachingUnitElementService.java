package referencedataguardian.service;

import referencedataguardian.dto.TeachingUnitElementDto;

import java.util.List;

public interface TeachingUnitElementService {

    boolean saveTeachingUnitElementsForOurSystem(List<TeachingUnitElementDto> teachingUnitElements);

}
