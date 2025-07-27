package referencedataguardian.service.mapper;

import org.springframework.stereotype.Component;
import referencedataguardian.dto.TeachingUnitDto;
import referencedataguardian.model.TeachingUnit;

@Component
public class TeachingUnitMapper {

    public TeachingUnitDto mapFromEntityToDto(TeachingUnit teachingUnit) {
        return TeachingUnitDto.builder()
                .code(teachingUnit.getCode())
                .name(teachingUnit.getName())
                .build();
    }

    public TeachingUnit mapFromDtoRequestToEntity(TeachingUnitDto teachingUnitDto) {
        TeachingUnit teachingUnit = new TeachingUnit();

        teachingUnit.setCode(teachingUnitDto.getCode());
        teachingUnit.setName(teachingUnitDto.getName());

        return teachingUnit;
    }

}
