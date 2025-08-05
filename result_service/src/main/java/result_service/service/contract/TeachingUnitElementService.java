package result_service.service.contract;

import result_service.dto.request_objects.TeachingUnitElementReq;
import result_service.model.TeachingUnitElement;

public interface TeachingUnitElementService {

    boolean saveTeachingUnitElement(TeachingUnitElementReq teachingUnitElementReq);

    TeachingUnitElement findTeachingUnitElementByCode(String code);

}