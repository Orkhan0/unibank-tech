package az.unibank.unibanktech.service.impl;


import az.unibank.unibanktech.domain.Account;
import az.unibank.unibanktech.domain.User;
import az.unibank.unibanktech.dto.request.AccountRequest;
import az.unibank.unibanktech.dto.response.AccountResponse;
import az.unibank.unibanktech.exception.GeneralException;
import az.unibank.unibanktech.repository.AccountRepository;
import az.unibank.unibanktech.service.AccountService;
import az.unibank.unibanktech.service.UserService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserService userService;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AccountResponse> getAllByUserPinCode(String pinCode) {
        User user = userService.findUserByPin(pinCode);
        return accountRepository.findAccountsByUserAndActiveIsTrue(user)
                .stream()
                .map(account -> modelMapper.map(account, AccountResponse.class))
                .collect(Collectors.toList());
    }


    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findAccountWhichTransferPossibleByAccountNumber(String accountNumber) {
        Account account = findAccountByAccountNumber(accountNumber);
        if (account.isActive() == Boolean.FALSE) {
            throw new GeneralException("Account isn't active");
        }
        return account;
    }

    @Override
    public void saveAccount(AccountRequest accountRequest) {
        User user = userService
                .findUserByPin(SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName());
        accountRepository.save(Account.builder()
                .user(user)
                .description(accountRequest.getDescription())
                .build());
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new GeneralException("Account not exist"));
    }

}