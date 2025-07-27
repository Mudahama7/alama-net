package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;
import referencedataguardian.model.enums.DeaneryMember_sPositionHeld;

@Data
@Builder
public class DeaneryMemberDto {

    private String registration_number;

    private String name;

    private String surname;

    private String first_name;

    private String email;

    private DeaneryMember_sPositionHeld position_held;

    private FacultyDto attached_faculty;
}
