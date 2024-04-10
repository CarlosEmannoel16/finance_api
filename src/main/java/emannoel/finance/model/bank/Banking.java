package emannoel.finance.model.bank;

import emannoel.finance.model.revenues.Revenues;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Banking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String ErrorMessage;

    @OneToMany(mappedBy = "banking", cascade = CascadeType.ALL)
    private List<Revenues> revenues;

}
