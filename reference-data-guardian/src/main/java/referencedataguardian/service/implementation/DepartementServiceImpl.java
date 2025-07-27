package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.DepartementDto;
import referencedataguardian.model.Departement;
import referencedataguardian.repository.DepartementRepository;
import referencedataguardian.service.DepartementService;
import referencedataguardian.service.mapper.DepartementMapper;
import java.util.List;

@AllArgsConstructor
@Service
public class DepartementServiceImpl implements DepartementService {

    private DepartementRepository departementRepository;
    private DepartementMapper departementMapper;

    @Override
    public boolean saveDepartementsForInitializeOurSystem(List<DepartementDto> departementDtoList) {
        List<Departement> departements = departementDtoList.stream()
                .map(departementDto -> departementMapper.mapFromDtoRequestToEntity(departementDto))
                .toList();
        return false;
    }

    @Override
    public Departement findDepartementByExternalId(String externalId) {
        return departementRepository.findByExternalId(externalId).orElse(null);
    }
}
