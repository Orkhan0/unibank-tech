package az.unibank.unibanktech.acount.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class AccountDto {

    private BigInteger amount;

    private String description;

    private boolean active;

}