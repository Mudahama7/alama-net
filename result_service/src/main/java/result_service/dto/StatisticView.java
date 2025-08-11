package result_service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StatisticView {

    private String distinction_total;
    private String success_total;
    private String slight_failure_total;
    private String deep_failure_total;

}
