package az.unibank.unibanktech.service;

import az.unibank.unibanktech.domain.Account;
import az.unibank.unibanktech.dto.request.AccountRequest;
import az.unibank.unibanktech.dto.response.AccountResponse;

import java.util.List;

public interface AccountService {
    void saveAccount(AccountRequest accountRequest);

    List<AccountResponse> getAllByUserPinCode(String pinCode);

    void update(Account account);

    Account findAccountWhichTransferPossibleByAccountNumber(String accountNumber);

    Account findAccountByAccountNumber(String accountNumber);

}