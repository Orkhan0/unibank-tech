package az.unibank.unibanktech.service;

import az.unibank.unibanktech.dto.request.TransferRequest;
import az.unibank.unibanktech.dto.response.TransferResponse;

public interface TransferService {
    TransferResponse transfer(TransferRequest transferRequest);
}
