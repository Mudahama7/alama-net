package referencedataguardian.service.contract;

import referencedataguardian.dto.DepartementDto;
import referencedataguardian.model.Departement;

import java.util.List;

public interface DepartementService {

    boolean saveDepartementsForInitializeOurSystem(List<DepartementDto> departementDtoList);

    Departement findDepartementByExternalId(String externalId);

}
