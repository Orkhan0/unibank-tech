package az.unibank.unibanktech.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserRequest {

    @NotBlank
    @Size(min = 4, max = 255)
    private String name;

    @NotBlank
    @Size(min = 4, max = 255)
    private String surname;

    @Size(min = 7, max = 7, message = "Pin length must be 7")
    @NotBlank
    private String pin;

    @NotBlank
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must have at least 1 uppercase, 1 lowercase letter and 1 number")
    private String password;

}