package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.FacultyDto;
import referencedataguardian.model.Faculty;
import referencedataguardian.repository.FacultyRepository;
import referencedataguardian.service.contract.FacultyService;
import referencedataguardian.service.mapper.FacultyMapper;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepository facultyRepository;

    @Override
    public boolean saveFacultiesForInitializeOurSystem(List<FacultyDto> faculties) {
        List<Faculty> facultyList = faculties.stream()
                .map(FacultyMapper::mapFromDtoRequestToEntity)
                .toList();
        facultyRepository.saveAll(facultyList);
        return true;
    }

    @Override
    public Faculty findByExternalId(String external_id) {
        Optional<Faculty> fac = facultyRepository.findByExternalId(external_id);
        return fac.orElse(null);
    }

}