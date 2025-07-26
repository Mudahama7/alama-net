package referencedataguardian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import referencedataguardian.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
