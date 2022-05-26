package az.unibank.unibanktech.controller;

import az.unibank.unibanktech.dto.request.TransferRequest;
import az.unibank.unibanktech.dto.response.TransferResponse;
import az.unibank.unibanktech.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public TransferResponse transfer(@RequestBody TransferRequest transferRequest) {
        return transferService.transfer(transferRequest);
    }

}