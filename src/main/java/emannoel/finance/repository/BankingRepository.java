package emannoel.finance.repository;

import emannoel.finance.model.bank.Banking;
import org.springframework.data.repository.CrudRepository;

public interface BankingRepository extends CrudRepository<Banking, Long> {
}
