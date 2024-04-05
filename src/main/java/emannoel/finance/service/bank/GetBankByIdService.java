package emannoel.finance.service.bank;

import emannoel.finance.model.bank.Banking;
import emannoel.finance.repository.BankingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetBankByIdService {

    private BankingRepository bankingRepository;
    public GetBankByIdService(BankingRepository bankingRepository){
        this.bankingRepository = bankingRepository;
    }

    public Optional<Banking> handler(Long id){
        Optional<Banking> bank = this.bankingRepository.findById(id);
        return bank;
    }
}
