package result_service.dto.request_objects;

import lombok.Data;

@Data
public class StudentReq {

    private String registration_number;
    private String email;
    private String name;
    private String surname;
    private String first_name;
    private String promotion_external_id;

}