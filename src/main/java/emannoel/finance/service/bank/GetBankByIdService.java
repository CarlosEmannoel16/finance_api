package emannoel.finance.service.bank;

import emannoel.finance.exceptions.NotFoundException;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.repository.BankingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetBankByIdService {

    private final BankingRepository bankingRepository;
    public GetBankByIdService(BankingRepository bankingRepository){
        this.bankingRepository = bankingRepository;
    }

    public Banking handler(Long id) throws NotFoundException {
        Optional<Banking> optional = this.bankingRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        throw  new NotFoundException("Bank not found");
    }
}
