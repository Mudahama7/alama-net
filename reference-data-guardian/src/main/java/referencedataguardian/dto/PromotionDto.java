package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class PromotionDto {

    private String designation;

    private BigDecimal total_fees;

    private String academic_year;

    private String external_id;

    private DepartementDto departement;

}
