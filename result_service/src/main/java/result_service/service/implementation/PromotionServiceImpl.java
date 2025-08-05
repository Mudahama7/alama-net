package result_service.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.request_objects.PromotionReq;
import result_service.model.Promotion;
import result_service.repository.PromotionRepository;
import result_service.service.contract.PromotionService;
import result_service.service.mapper.PromotionMapper;

@AllArgsConstructor
@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    private final PromotionMapper promotionMapper;

    @Override
    public boolean savePromotion(PromotionReq promotionReq) {
        Promotion promotion = promotionMapper.mapFromRequestToEntity(promotionReq);
        promotionRepository.save(promotion);

        return true;
    }

    @Override
    public Promotion findPromotionByExternal_id(String external_id) {
        return promotionRepository.findByExternalId(external_id).orElse(null);
    }
}
