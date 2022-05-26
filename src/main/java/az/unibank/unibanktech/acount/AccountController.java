package az.unibank.unibanktech.acount;

import az.unibank.unibanktech.acount.dto.AccountDto;
import az.unibank.unibanktech.shared.GenericResponse;
import az.unibank.unibanktech.shared.CurrentUser;
import az.unibank.unibanktech.user.User;
import az.unibank.unibanktech.user.dto.UserDto;
import az.unibank.unibanktech.user.UserService;
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
public class AccountController {

    private final AccountService accountService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @PostMapping("/accounts")
    public GenericResponse saveAccount(@RequestBody @Valid AccountDto accountDto, @CurrentUser User principal) {
        User user = userService.findUserByPin(principal.getPin());
        UserDto userDto = modelMapper.map(user, UserDto.class);
        accountService.saveAccount(accountDto, userDto);
        return new GenericResponse("account created");
    }


}