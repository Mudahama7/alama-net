package result_service.dto.request_objects;

import lombok.Data;

@Data
public class TeachingUnitElementReq {

    private String code;
    private String designation;
    private int credits;
    private String teachingUnitDesignation;
    private String promotion_external_id;

}