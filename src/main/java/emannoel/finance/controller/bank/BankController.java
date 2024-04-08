package emannoel.finance.controller.bank;


import emannoel.finance.DTOs.BankingRequestDTO;
import emannoel.finance.DTOs.UpdateRequestBankDTO;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.service.bank.CreateBankingService;
import emannoel.finance.service.bank.DeleteBankingService;
import emannoel.finance.service.bank.GetBankByIdService;
import emannoel.finance.service.bank.UpdateBankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BankController {

    private CreateBankingService createBankingService;
    private GetBankByIdService getBankByIdService;
    private DeleteBankingService deleteBankingService;
    private UpdateBankingService updateBankingService;

    public BankController(
            CreateBankingService createBankingService,
            GetBankByIdService getBankByIdService,
            DeleteBankingService deleteBankingService
    ) {
        this.createBankingService = createBankingService;
        this.getBankByIdService = getBankByIdService;
        this.deleteBankingService = deleteBankingService;

    }

    @PostMapping("/bank")
    public String create(@RequestBody BankingRequestDTO bankingRequestDTO) {
        this.createBankingService.create(bankingRequestDTO);
        return "created";
    }

    @GetMapping("/bank/{id}")
    public Optional<Banking> getById(@PathVariable Long id) {
        Optional<Banking> bank = this.getBankByIdService.handler(id);
        return bank;
    }

    @DeleteMapping("/bank/{id}")
    public String delete(@PathVariable Long id) {
        this.deleteBankingService.handler(id);
        return "deleted";

    }

    @PutMapping("/bank")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UpdateRequestBankDTO updateBankRequestDTO) {

        try {
            this.updateBankingService.handler(updateBankRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(e.getLocalizedMessage());
        }

    }
}
