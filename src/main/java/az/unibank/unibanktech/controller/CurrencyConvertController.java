package az.unibank.unibanktech.controller;

import az.unibank.unibanktech.dto.response.ExchangeResponse;
import az.unibank.unibanktech.service.impl.CurrencyConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyConvertController {

    private final CurrencyConverterService currencyConverterService;


    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<ExchangeResponse> currencyConverter(@PathVariable String from, @PathVariable String to, @RequestParam String amount)  {
        ExchangeResponse exchangeModel = currencyConverterService.currencyConverter(to, from, amount);
        return ResponseEntity.ok(exchangeModel);
    }

}