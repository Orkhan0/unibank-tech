package az.unibank.unibanktech.service.impl;


import az.unibank.unibanktech.domain.Account;
import az.unibank.unibanktech.repository.AccountRepository;
import az.unibank.unibanktech.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void when_get_account_number_then_get_successful_account() {
        //Arrange
        Account account = Account
                .builder()
                .accountNumber("blabla")
                .build();
        when(accountRepository.findByAccountNumber("blabla")).thenReturn(Optional.of(account));
        //Act
        Account currentAccount = accountService.findAccountByAccountNumber("blabla");
        //Assert
        assertEquals("blabla", currentAccount.getAccountNumber());
    }

    @Test
    void when_get_account_number_then_get_exception() {
        //Arrange
        Account account = Account
                .builder()
                .accountNumber("blabla")
                .build();
        when(accountRepository.findByAccountNumber("blabla")).thenReturn(Optional.of(account));
        //Act
        Account currentAccount = accountService.findAccountByAccountNumber("blabl");
        //Assert

        assertThrows(RuntimeException.class, this::when_get_account_number_then_get_exception);
    }
}