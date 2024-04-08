package emannoel.finance.service.bank;

import emannoel.finance.exceptions.NotFoundException;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.repository.BankingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBankingService {

    private final BankingRepository bankingRepository;
    public DeleteBankingService(BankingRepository bankingRepository){
        this.bankingRepository = bankingRepository;
    }

    public void handler(Long id) throws NotFoundException{

        Optional<Banking> bank = this.bankingRepository.findById(id);
        if(bank.isPresent()){
            this.bankingRepository.deleteById(id);
            return;
        }
        throw new NotFoundException("Bank Not found");

    }

}
