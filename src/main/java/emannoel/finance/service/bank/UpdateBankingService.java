package emannoel.finance.service.bank;


import emannoel.finance.DTOs.UpdateRequestBankDTO;
import emannoel.finance.exceptions.NotFoundException;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.repository.BankingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBankingService {

    private BankingRepository bankingRepository;

     UpdateBankingService(BankingRepository bankingRepository){
         this.bankingRepository = bankingRepository;
     }

    public void handler(UpdateRequestBankDTO updateRequestBankDTO) throws NotFoundException {

        Optional<Banking> bankingOptional = this.bankingRepository.findById(updateRequestBankDTO.id());
        if(bankingOptional.isPresent()) {
            Banking bank = bankingOptional.get();
            bank.setName(updateRequestBankDTO.name());
            this.bankingRepository.save(bank);
            return;
        }
        throw new NotFoundException("Banco não encontrado");

     }
}
