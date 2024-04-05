package emannoel.finance.controller.bank;


import emannoel.finance.DTOs.BankingRequestDTO;
import emannoel.finance.model.bank.AddBankingData;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.service.bank.CreateBankingService;
import emannoel.finance.service.bank.GetBankByIdService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BankController {

    private CreateBankingService createBankingService;
    private GetBankByIdService getBankByIdService;

    public BankController(CreateBankingService createBankingService, GetBankByIdService getBankByIdService){
        this.createBankingService = createBankingService;
        this.getBankByIdService = getBankByIdService;

    }
    @PostMapping("/bank")
    public String create(@RequestBody BankingRequestDTO bankingRequestDTO){
       System.out.println(bankingRequestDTO.name());
       this.createBankingService.create(bankingRequestDTO);
       return "created";
    }


    @GetMapping("/bank/{id}")
    public Optional<Banking> getById(@PathVariable Long id){
        Optional<Banking> bank = this.getBankByIdService.handler(id);
        return  bank;
    }
}
