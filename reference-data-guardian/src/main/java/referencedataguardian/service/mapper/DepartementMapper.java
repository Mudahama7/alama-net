package referencedataguardian.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import referencedataguardian.dto.DepartementDto;
import referencedataguardian.model.Departement;
import referencedataguardian.service.contract.FacultyService;

@AllArgsConstructor
@Component
public class DepartementMapper {

    private final FacultyService facultyService;

    public DepartementDto mapFromEntityToDto(Departement departement) {
        return DepartementDto.builder()
                .faculty(FacultyMapper.mapFromEntityToDto(departement.getFaculty()))
                .external_id(departement.getExternalId())
                .designation(departement.getDesignation())
                .build();
    }

    public Departement mapFromDtoRequestToEntity(DepartementDto dto) {
        Departement departement = new Departement();

        departement.setExternalId(dto.getExternal_id());
        departement.setDesignation(dto.getDesignation());
        departement.setFaculty(facultyService.findByExternalId(dto.getFaculty().getExternal_id()));
        departement.setChefName(dto.getChef_name());

        return departement;
    }
}
