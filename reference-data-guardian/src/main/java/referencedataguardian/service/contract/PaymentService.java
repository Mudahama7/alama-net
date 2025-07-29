package referencedataguardian.service.contract;

import referencedataguardian.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    boolean savePayementsForInitializeOurSystem(List<PaymentDto> payments);

}
