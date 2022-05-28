package az.unibank.unibanktech.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class ExchangeResponse {
    private BigDecimal result;
}