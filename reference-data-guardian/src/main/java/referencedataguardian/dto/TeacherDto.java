package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeacherDto {

    private String registration_number;

    private String name;

    private String surname;

    private String first_name;

    private String level;

    private String email;

}
