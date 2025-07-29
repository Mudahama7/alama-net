package referencedataguardian.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import referencedataguardian.dto.PromotionDto;
import referencedataguardian.model.Promotion;
import referencedataguardian.service.contract.DepartementService;

@AllArgsConstructor
@Component
public class PromotionMapper {

    private DepartementMapper departementMapper;
    private DepartementService departementService;

    public PromotionDto mapFromEntityToDto(Promotion promotion) {
        return PromotionDto.builder()
                .departement(departementMapper.mapFromEntityToDto(promotion.getDepartement()))
                .academic_year(promotion.getAcademic_year())
                .designation(promotion.getDesignation())
                .external_id(promotion.getExternalId())
                .total_fees(promotion.getTotal_fees())
                .build();
    }

    public Promotion mapFromDtoRequestToEntity(PromotionDto promotionDto) {
        Promotion promotion = new Promotion();

        promotion.setAcademic_year(promotionDto.getAcademic_year());
        promotion.setExternalId(promotionDto.getExternal_id());
        promotion.setDesignation(promotionDto.getDesignation());
        promotion.setDepartement(departementService.findDepartementByExternalId(promotionDto.getDepartement().getExternal_id()));
        promotion.setTotal_fees(promotionDto.getTotal_fees());

        return promotion;
    }

}
