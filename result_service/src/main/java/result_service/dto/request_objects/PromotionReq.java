package result_service.dto.request_objects;

import lombok.Data;

@Data
public class PromotionReq {

    private String designation;
    private String department;
    private String faculty;
    private String external_id;
    private String academic_year;

}