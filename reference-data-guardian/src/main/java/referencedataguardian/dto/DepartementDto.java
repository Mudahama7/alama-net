package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DepartementDto {

    private String designation;

    private String chef_name;

    private String external_id;

    private FacultyDto faculty;

}
