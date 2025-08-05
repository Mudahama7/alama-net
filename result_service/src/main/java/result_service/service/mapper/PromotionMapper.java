package result_service.service.mapper;

import org.springframework.stereotype.Service;
import result_service.dto.request_objects.PromotionReq;
import result_service.model.Promotion;

@Service
public class PromotionMapper {

    public Promotion mapFromRequestToEntity(PromotionReq promotionReq) {
        Promotion promotion = new Promotion();

        promotion.setAcademic_year(promotionReq.getAcademic_year());
        promotion.setDepartment(promotionReq.getDepartment());
        promotion.setDesignation(promotionReq.getDesignation());
        promotion.setExternalId(promotionReq.getExternal_id());
        promotion.setFaculty(promotionReq.getFaculty());

        return promotion;
    }

}
