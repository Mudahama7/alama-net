package referencedataguardian.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import referencedataguardian.dto.DeaneryMemberDto;
import referencedataguardian.model.DeaneryMember;
import referencedataguardian.service.contract.FacultyService;

@AllArgsConstructor
@Component
public class DeaneryMemberMapper {

    private final FacultyService facultyService;

    public DeaneryMemberDto mapFromEntityToDto(DeaneryMember deaneryMember) {
        return DeaneryMemberDto.builder()
                .position_held(deaneryMember.getPosition_held())
                .attached_faculty(FacultyMapper.mapFromEntityToDto(deaneryMember.getAttached_faculty()))
                .email(deaneryMember.getEmail())
                .name(deaneryMember.getName())
                .first_name(deaneryMember.getFirst_name())
                .registration_number(deaneryMember.getRegistration_number())
                .surname(deaneryMember.getSurname())
                .build();
    }

    public DeaneryMember mapFromDtoRequestToEntity(DeaneryMemberDto dto) {
        DeaneryMember deaneryMember = new DeaneryMember();

        deaneryMember.setEmail(dto.getEmail());
        deaneryMember.setName(dto.getName());
        deaneryMember.setFirst_name(dto.getFirst_name());
        deaneryMember.setRegistration_number(dto.getRegistration_number());
        deaneryMember.setSurname(dto.getSurname());
        deaneryMember.setPosition_held(dto.getPosition_held());
        deaneryMember.setAttached_faculty(facultyService.findByExternalId(dto.getAttached_faculty().getExternal_id()));

        return deaneryMember;
    }

}
