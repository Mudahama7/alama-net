package referencedataguardian.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class PaymentDto {

    private BigDecimal amount;
    private LocalDate payment_date;
    private String student_registration_number;

}
