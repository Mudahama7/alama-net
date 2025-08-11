package result_service.service.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import result_service.dto.ResultBulletinLine;
import result_service.model.AverageInTUE;

@AllArgsConstructor
@Service
public class AverageInTUEMapper {

    public ResultBulletinLine fromAverageInTUEToResultSlipLine(AverageInTUE averageInTUE) {
        return ResultBulletinLine.builder()
                .teaching_unit_credits(averageInTUE.getTeachingUnitElement().getCredits())
                .teaching_unit_element_designation(averageInTUE.getTeachingUnitElement().getDesignation())
                .teaching_unit_obtained_average_on_tp_td(averageInTUE.getAverage_on_tp_td())
                .teaching_unit_obtained_average_on_interrogation(averageInTUE.getAverage_on_interrogation())
                .teaching_unit_obtained_average_on_exam(averageInTUE.getAverage_on_exam())
                .teaching_unit_general_obtained_average(
                        averageInTUE.getAverage_on_exam() +
                                averageInTUE.getAverage_on_interrogation() +
                                averageInTUE.getAverage_on_tp_td()
                )
                .build();
    }

}
