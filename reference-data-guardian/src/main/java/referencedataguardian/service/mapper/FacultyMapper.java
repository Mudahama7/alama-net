package referencedataguardian.service.mapper;

import lombok.Data;
import referencedataguardian.dto.FacultyDto;
import referencedataguardian.model.Faculty;

@Data
public class FacultyMapper {

    public static FacultyDto mapFromEntityToDto(Faculty faculty) {
        return FacultyDto.builder()
                .faculty_name(faculty.getFacultyName())
                .external_id(faculty.getExternalId())
                .build();
    }

    public static Faculty mapFromDtoRequestToEntity(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyDto.getFaculty_name());
        faculty.setExternalId(facultyDto.getExternal_id());
        return faculty;
    }

}
