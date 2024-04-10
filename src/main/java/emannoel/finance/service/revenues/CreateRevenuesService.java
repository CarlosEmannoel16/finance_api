package emannoel.finance.service.revenues;

import emannoel.finance.DTOs.requests.RevenuesRequestDTO;
import emannoel.finance.exceptions.NotFoundException;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.model.revenues.Revenues;
import emannoel.finance.repository.BankingRepository;
import emannoel.finance.repository.RevenuesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateRevenuesService {

    private final RevenuesRepository revenuesRepository;
    private final BankingRepository bankingRepository;

    CreateRevenuesService(RevenuesRepository revenuesRepository, BankingRepository bankingRepository) {
        this.revenuesRepository = revenuesRepository;
        this.bankingRepository = bankingRepository;
    }

    public Revenues handler(RevenuesRequestDTO data) throws Exception {
        Optional<Banking> optionalBank = this.bankingRepository.findById(data.idBank());

        if (optionalBank.isPresent()) {
            Revenues revenueToInsert = new Revenues();
            revenueToInsert.setAmount(data.amount());
            revenueToInsert.setDescription(data.description());
            revenueToInsert.setDateOfOccurrence(data.dateOfRevenue());
            Banking bank = optionalBank.get();
            revenueToInsert.setBanking(bank);

            this.revenuesRepository.save(revenueToInsert);
            return revenueToInsert;
        }

        throw new NotFoundException("Banco não encontrado");

    }
}
