package emannoel.finance.controller.revenue;


import emannoel.finance.DTOs.requests.RevenuesRequestDTO;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.model.revenues.Revenues;
import emannoel.finance.service.revenues.CreateRevenuesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevenueController {

    private final CreateRevenuesService createRevenuesService;

    public RevenueController(CreateRevenuesService createRevenuesService) {
        this.createRevenuesService = createRevenuesService;
    }


    @PostMapping("/revenue")

    public ResponseEntity<Revenues> create(@RequestBody RevenuesRequestDTO body) {

        try {
            Revenues revenue = this.createRevenuesService.handler(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(revenue);
        } catch (Exception e) {
            Revenues revenues = new Revenues();
            revenues.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(revenues);
        }


    }
}
