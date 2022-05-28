package az.unibank.unibanktech.service.impl;


import az.unibank.unibanktech.domain.Account;
import az.unibank.unibanktech.repository.AccountRepository;
import az.unibank.unibanktech.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    UserService userService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl(userService, accountRepository, modelMapper);
    }

    @Test
    void when_get_account_number_then_get_successful_account() {
        Account account = Account
                .builder()
                .accountNumber("blabla")
                .build();
        when(accountRepository.findByAccountNumber("blabla")).thenReturn(Optional.of(account));

        Account currentAccount = accountService.findAccountByAccountNumber("blabla");

        assertEquals("blabla", currentAccount.getAccountNumber());
    }

}