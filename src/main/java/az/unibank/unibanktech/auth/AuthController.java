package az.unibank.unibanktech.auth;

import az.unibank.unibanktech.shared.CurrentUser;
import az.unibank.unibanktech.user.User;
import az.unibank.unibanktech.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/api/1.0/auth")
    UserDto handleAuthentication(@CurrentUser User user) {
        return new UserDto(user);
    }

}