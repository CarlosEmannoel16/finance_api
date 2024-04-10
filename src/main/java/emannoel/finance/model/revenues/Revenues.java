package emannoel.finance.model.revenues;

import emannoel.finance.model.bank.Banking;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Revenues {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Double amount;
    private Date dateOfOccurrence;
    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "id_bank", nullable = false)
    private Banking banking;
}
