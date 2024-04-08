package emannoel.finance.service.bank;

import emannoel.finance.repository.BankingRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteBankingService {

    private BankingRepository bankingRepository;
    public DeleteBankingService(BankingRepository bankingRepository){
        this.bankingRepository = bankingRepository;
    }

    public String handler(Long id){
        this.bankingRepository.deleteById(id);
        return "Banking Deleted";
    }

}
