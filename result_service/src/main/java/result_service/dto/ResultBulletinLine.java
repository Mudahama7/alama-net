package result_service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResultBulletinLine {

    private String teaching_unit_element_designation;
    private int teaching_unit_credits;

    private Double teaching_unit_obtained_average_on_tp_td;
    private Double teaching_unit_obtained_average_on_interrogation;
    private Double teaching_unit_obtained_average_on_exam;
    private Double teaching_unit_general_obtained_average;

}