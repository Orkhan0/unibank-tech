package az.unibank.unibanktech.user.dto;

import lombok.Data;

@Data
public class UserRequestDto {

    private String name;

    private String surname;

    private String pin;

    private String password;

}