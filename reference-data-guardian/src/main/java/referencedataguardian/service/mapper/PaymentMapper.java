package referencedataguardian.service.mapper;

import org.springframework.stereotype.Component;
import referencedataguardian.dto.PaymentDto;
import referencedataguardian.model.Payment;

@Component
public class PaymentMapper {

    public PaymentDto mapFromEntityToDto(Payment payment) {
        return PaymentDto.builder()
                .payment_date(payment.getPayment_date())
                .amount(payment.getAmount())
                .student_registration_number(payment.getStudent_registration_number())
                .build();
    }

    public Payment mapFromDtoRequestToEntity(PaymentDto paymentDto) {
        Payment payment = new Payment();
        payment.setPayment_date(paymentDto.getPayment_date());
        payment.setAmount(paymentDto.getAmount());
        payment.setStudent_registration_number(paymentDto.getStudent_registration_number());
        return payment;
    }

}
