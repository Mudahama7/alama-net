package referencedataguardian.service;

import referencedataguardian.dto.FacultyDto;
import referencedataguardian.model.Faculty;

import java.util.List;

public interface FacultyService {

    boolean saveFacultiesForInitializeOurSystem(List<FacultyDto> faculties);

    Faculty findByExternalId(String external_id);

}
