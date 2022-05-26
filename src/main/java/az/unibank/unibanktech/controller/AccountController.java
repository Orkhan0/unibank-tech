package az.unibank.unibanktech.controller;

import az.unibank.unibanktech.dto.request.AccountRequest;
import az.unibank.unibanktech.dto.response.AccountResponse;
import az.unibank.unibanktech.service.impl.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAccount(@RequestBody @Valid AccountRequest accountRequest) {
        accountService.saveAccount(accountRequest);
    }

    @GetMapping("/user/{pinCode}")
    public List<AccountResponse> getAllAccountByUserPin(@Positive @PathVariable("pinCode") String pinCode) {
        return accountService.getAllByUserPinCode(pinCode);
    }

}