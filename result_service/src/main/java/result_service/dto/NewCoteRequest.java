package result_service.dto;

import lombok.Builder;
import lombok.Data;
import result_service.dto.request_objects.PromotionReq;
import result_service.dto.request_objects.StudentReq;
import result_service.dto.request_objects.TeachingUnitElementReq;

@Data
@Builder
public class NewCoteRequest {

    private PromotionReq promotionReq;
    private TeachingUnitElementReq teachingUnitElementReq;
    private StudentReq studentReq;

    private Double cote;
    private Double total;
    private String type_cote;

}