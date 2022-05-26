package az.unibank.unibanktech.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class AccountResponse {
    private Long id;
    private String description;
    private boolean active;
    private BigDecimal amount;
    private String accountNumber;
}