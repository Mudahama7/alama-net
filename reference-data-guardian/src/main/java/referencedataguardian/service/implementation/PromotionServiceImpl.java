package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.PromotionDto;
import referencedataguardian.model.Promotion;
import referencedataguardian.repository.PromotionRepository;
import referencedataguardian.service.PromotionService;
import referencedataguardian.service.mapper.PromotionMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepository promotionRepository;
    private PromotionMapper promotionMapper;

    @Override
    public boolean savePromotionsForInitializeOurSystem(List<PromotionDto> promotions) {
        List<Promotion> promotionsToSave = promotions.stream()
                .map(promotionDto -> promotionMapper.mapFromDtoRequestToEntity(promotionDto))
                .toList();
        promotionRepository.saveAll(promotionsToSave);

        return true;
    }

    @Override
    public Promotion getPromotionByExternalId(String externalId) {
        return promotionRepository.findByExternalId(externalId).orElse(null);
    }


}
