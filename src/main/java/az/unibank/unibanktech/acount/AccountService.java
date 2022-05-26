package az.unibank.unibanktech.acount;

import az.unibank.unibanktech.acount.dto.AccountDto;
import az.unibank.unibanktech.user.User;
import az.unibank.unibanktech.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void saveAccount(AccountDto accountDto, UserDto userDto) {
        Account mapAccount = modelMapper.map(accountDto, Account.class);
        User mapUser = modelMapper.map(userDto, User.class);
        mapAccount.setUser(mapUser);
        accountRepository.save(mapAccount);
    }

}