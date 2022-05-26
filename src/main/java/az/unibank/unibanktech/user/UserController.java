package az.unibank.unibanktech.user;

import az.unibank.unibanktech.shared.GenericResponse;
import az.unibank.unibanktech.user.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/users")
    public GenericResponse createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        User user = modelMapper.map(userRequestDto, User.class);
        userService.saveUser(user);
        return new GenericResponse("user created");
    }


}