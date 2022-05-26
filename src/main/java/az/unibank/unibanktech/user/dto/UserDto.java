package az.unibank.unibanktech.user.dto;

import az.unibank.unibanktech.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDto {

    private String name;

    private String surname;

    private String pin;

    public UserDto(User user) {
        this.setName(user.getName());
        this.setSurname(user.getSurname());
        this.setPin(user.getPin());
    }

}