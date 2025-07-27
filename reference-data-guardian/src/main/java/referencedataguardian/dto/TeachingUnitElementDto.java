package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TeachingUnitElementDto {

    private String code;

    private String name;

    private int credits;

    private int hourly_volume;

    private TeacherDto teacher;

    private TeachingUnitDto teachingUnit;

}
