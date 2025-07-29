package referencedataguardian.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import referencedataguardian.dto.TeachingUnitElementDto;
import referencedataguardian.model.TeachingUnitElement;
import referencedataguardian.service.contract.TeacherService;
import referencedataguardian.service.contract.TeachingUnitService;

@AllArgsConstructor
@Component
public class TeachingUnitElementMapper {

    private final TeacherMapper teacherMapper;
    private final TeacherService teacherService;
    private final TeachingUnitService teachingUnitService;

    public TeachingUnitElementDto mapFromEntityToDto(TeachingUnitElement teachingUnitElement) {
        return TeachingUnitElementDto.builder()
                .teacher(teacherMapper.mapFromEntityToDto(teachingUnitElement.getTeacher()))
                .name(teachingUnitElement.getName())
                .code(teachingUnitElement.getCode())
                .hourly_volume(teachingUnitElement.getHourly_volume())
                .credits(teachingUnitElement.getCredits())
                .credits(teachingUnitElement.getCredits())
                .build();
    }

    public TeachingUnitElement mapFromDtoRequestToEntity(TeachingUnitElementDto dto) {
        TeachingUnitElement teachingUnitElement = new TeachingUnitElement();

        teachingUnitElement.setName(dto.getName());
        teachingUnitElement.setCode(dto.getCode());
        teachingUnitElement.setHourly_volume(dto.getHourly_volume());
        teachingUnitElement.setCredits(dto.getCredits());
        teachingUnitElement.setTeacher(teacherService.findByEmail(dto.getTeacher().getEmail()));
        teachingUnitElement.setTeachingUnit(teachingUnitService.findByCode(dto.getTeachingUnit().getCode()));

        return teachingUnitElement;

    }


}
