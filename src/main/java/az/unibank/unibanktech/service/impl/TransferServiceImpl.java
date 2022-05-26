package az.unibank.unibanktech.service.impl;

import az.unibank.unibanktech.domain.Account;
import az.unibank.unibanktech.domain.Transfer;
import az.unibank.unibanktech.dto.request.TransferRequest;
import az.unibank.unibanktech.dto.response.TransferResponse;
import az.unibank.unibanktech.exception.GeneralException;
import az.unibank.unibanktech.repository.TransferRepository;
import az.unibank.unibanktech.service.AccountService;
import az.unibank.unibanktech.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final AccountService accountService;
    private final TransferRepository transferRepository;
    private final ModelMapper modelMapper;

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) {
        Account senderAccount = accountService
                .findAccountByAccountNumber(transferRequest.getSenderAccountNumber());
        if (senderAccount.getAmount().compareTo(transferRequest.getAmount()) < 0) {
            throw new GeneralException("Transfer isn't possible because money problem");
        }

        if(transferRequest.getSenderAccountNumber()
                .equalsIgnoreCase(transferRequest.getReceiverAccountNumber())) {
            throw new GeneralException("Account number is same");
        }

        Account receiverAccount = accountService
                .findAccountWhichTransferPossibleByAccountNumber(transferRequest.getReceiverAccountNumber());

        BigDecimal transferAmount = transferRequest.getAmount();
        senderAccount.setAmount(senderAccount.getAmount().subtract(transferAmount));
        accountService.update(senderAccount);
        receiverAccount.setAmount(receiverAccount.getAmount().add(transferAmount));
        accountService.update(receiverAccount);

        Transfer transfer = transferRepository
                .save(Transfer.builder()
                        .senderAccountNumber(transferRequest.getSenderAccountNumber())
                        .receiverAccountNumber(transferRequest.getReceiverAccountNumber())
                        .amount(transferAmount)
                        .senderMessage(transferRequest.getSenderMessage())
                        .build());
        return modelMapper
                .map(transfer, TransferResponse.class);
    }

}