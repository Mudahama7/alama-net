package result_service.service.contract;

import result_service.dto.request_objects.PromotionReq;
import result_service.model.Promotion;

public interface PromotionService {

    boolean savePromotion(PromotionReq promotionReq);

    Promotion findPromotionByExternal_id(String external_id);

}
