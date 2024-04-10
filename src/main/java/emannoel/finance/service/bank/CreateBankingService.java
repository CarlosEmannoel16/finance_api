package emannoel.finance.service.bank;

import emannoel.finance.model.bank.Banking;
import emannoel.finance.DTOs.requests.BankingRequestDTO;
import emannoel.finance.repository.BankingRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateBankingService {

    private final BankingRepository bankingRepository;

    public CreateBankingService(BankingRepository bankingRepository){
        this.bankingRepository = bankingRepository;
    }

    public Banking handler(BankingRequestDTO bankingDTO){
        Banking banking = new Banking();
        banking.setName(bankingDTO.name());
        return this.bankingRepository.save(banking);
    }

}
