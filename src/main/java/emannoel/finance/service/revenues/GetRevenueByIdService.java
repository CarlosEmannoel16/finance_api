package emannoel.finance.service.revenues;


import emannoel.finance.exceptions.NotFoundException;
import emannoel.finance.model.revenues.Revenues;
import emannoel.finance.repository.RevenuesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetRevenueByIdService {

    private final RevenuesRepository revenuesRepository;

    public GetRevenueByIdService(RevenuesRepository revenuesRepository) {
        this.revenuesRepository = revenuesRepository;
    }


    public Revenues handler(Long id) throws Exception {

        Optional<Revenues> revenue = this.revenuesRepository.findById(id);
        if (revenue.isPresent()) {
            return revenue.get();
        }

        throw new NotFoundException("Receita não encontarda");
    }
}
