package emannoel.finance.controller.bank;


import emannoel.finance.DTOs.requests.BankingRequestDTO;
import emannoel.finance.DTOs.requests.UpdateRequestBankDTO;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.service.bank.CreateBankingService;
import emannoel.finance.service.bank.DeleteBankingService;
import emannoel.finance.service.bank.GetBankByIdService;
import emannoel.finance.service.bank.UpdateBankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    private final CreateBankingService createBankingService;
    private final GetBankByIdService getBankByIdService;
    private final DeleteBankingService deleteBankingService;
    private final UpdateBankingService updateBankingService;

    public BankController(CreateBankingService createBankingService, GetBankByIdService getBankByIdService, DeleteBankingService deleteBankingService, UpdateBankingService updateBankingService) {
        this.createBankingService = createBankingService;
        this.getBankByIdService = getBankByIdService;
        this.deleteBankingService = deleteBankingService;
        this.updateBankingService = updateBankingService;
    }

    @PostMapping("/bank")
    public ResponseEntity<Banking> create(@RequestBody BankingRequestDTO bankingRequestDTO) {
        try {
            Banking bank = this.createBankingService.handler(bankingRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(bank);
        } catch (Exception e) {

            Banking bank = new Banking();
            bank.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(bank);
        }
    }

    @GetMapping("/bank/{id}")
    public ResponseEntity<Banking> getById(@PathVariable Long id) throws Exception {
        try {
            Banking bank = this.getBankByIdService.handler(id);
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(bank);
        } catch (Exception e) {
            Banking bank = new Banking();
            bank.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(bank);
        }
    }

    @DeleteMapping("/bank/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            this.deleteBankingService.handler(id);
            return ResponseEntity.status(HttpStatus.OK).body("Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(e.getMessage());
        }
    }

    @PutMapping("/bank")
    public ResponseEntity<String> update(@RequestBody UpdateRequestBankDTO updateBankRequestDTO) {
        try {
            this.updateBankingService.handler(updateBankRequestDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(e.getMessage());
        }
    }
}
