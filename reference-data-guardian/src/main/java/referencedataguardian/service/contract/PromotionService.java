package referencedataguardian.service.contract;

import referencedataguardian.dto.PromotionDto;
import referencedataguardian.model.Promotion;

import java.util.List;

public interface PromotionService {

    boolean savePromotionsForInitializeOurSystem(List<PromotionDto> promotionsDto);

    Promotion getPromotionByExternalId(String externalId);

}
