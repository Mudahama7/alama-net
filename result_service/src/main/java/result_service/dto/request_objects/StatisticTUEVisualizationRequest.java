package result_service.dto.request_objects;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatisticTUEVisualizationRequest {
    String codeTeachingUnit, type_cote;
}
