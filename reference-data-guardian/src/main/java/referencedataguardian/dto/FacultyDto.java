package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FacultyDto {

    private String faculty_name;

    private String external_id;
}
