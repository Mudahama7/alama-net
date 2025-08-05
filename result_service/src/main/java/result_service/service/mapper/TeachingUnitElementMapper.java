package result_service.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.request_objects.TeachingUnitElementReq;
import result_service.model.TeachingUnitElement;
import result_service.service.contract.PromotionService;

@AllArgsConstructor
@Service
public class TeachingUnitElementMapper {

    private final PromotionService promotionService;

    public TeachingUnitElement mapFromDtoToEntity(TeachingUnitElementReq teachingUnitElementReq) {
        TeachingUnitElement teachingUnitElement = new TeachingUnitElement();

        teachingUnitElement.setTeachingUnitDesignation(teachingUnitElementReq.getTeachingUnitDesignation());
        teachingUnitElement.setCode(teachingUnitElementReq.getCode());
        teachingUnitElement.setCredits(teachingUnitElementReq.getCredits());
        teachingUnitElement.setPromotion(promotionService.findPromotionByExternal_id(teachingUnitElementReq.getPromotion_external_id()));
        teachingUnitElement.setDesignation(teachingUnitElementReq.getDesignation());

        return teachingUnitElement;
    }

}