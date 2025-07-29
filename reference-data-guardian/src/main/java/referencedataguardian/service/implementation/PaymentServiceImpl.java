package referencedataguardian.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import referencedataguardian.dto.PaymentDto;
import referencedataguardian.model.Payment;
import referencedataguardian.repository.PaymentRepository;
import referencedataguardian.service.contract.PaymentService;
import referencedataguardian.service.mapper.PaymentMapper;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private PaymentMapper paymentMapper;

    @Override
    public boolean savePayementsForInitializeOurSystem(List<PaymentDto> payments) {
        List<Payment> paymentList = payments.stream()
                .map(paymentMapper::mapFromDtoRequestToEntity)
                .toList();

        paymentRepository.saveAll(paymentList);

        return true;
    }
}
