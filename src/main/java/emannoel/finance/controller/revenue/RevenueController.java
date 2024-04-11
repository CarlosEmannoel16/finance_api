package emannoel.finance.controller.revenue;


import emannoel.finance.DTOs.requests.RevenuesRequestDTO;
import emannoel.finance.model.bank.Banking;
import emannoel.finance.model.revenues.Revenues;
import emannoel.finance.service.revenues.CreateRevenuesService;
import emannoel.finance.service.revenues.GetRevenueByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RevenueController {

    private final CreateRevenuesService createRevenuesService;
    private final GetRevenueByIdService getRevenueByIdService;

    public RevenueController(CreateRevenuesService createRevenuesService, GetRevenueByIdService getRevenueByIdService) {
        this.createRevenuesService = createRevenuesService;
        this.getRevenueByIdService = getRevenueByIdService;
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

    @GetMapping("/revenue/{id}")
    public ResponseEntity<Revenues> getById(@PathVariable Long id) {

        try {
            Revenues revenues = this.getRevenueByIdService.handler(id);
            return ResponseEntity.status(HttpStatus.OK).body(revenues);
        } catch (Exception e) {
            Revenues revenues = new Revenues();
            revenues.setErrorMessage(e.getMessage());
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(revenues);
        }

    }
}
