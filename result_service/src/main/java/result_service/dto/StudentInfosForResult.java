package result_service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentInfosForResult {

    private String student_registration_number;
    private String student_full_name;
}
