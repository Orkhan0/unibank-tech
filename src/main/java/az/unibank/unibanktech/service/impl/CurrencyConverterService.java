package az.unibank.unibanktech.service.impl;

import az.unibank.unibanktech.dto.response.ExchangeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class CurrencyConverterService {

    @Value("${access_key}")
    private String ACCESS_KEY;
    private final CacheManager cacheManager;

    @Cacheable("currentcycache")
    public ExchangeResponse currencyConverter(String to, String from, String amount) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.add("apikey", ACCESS_KEY);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String BASE_URL = "https://api.apilayer.com/";

        ResponseEntity<ExchangeResponse> exchange = restTemplate.exchange(BASE_URL + "currency_data/convert?to=" + to + "&from=" + from + "&amount=" + amount,
                HttpMethod.GET, entity, ExchangeResponse.class);

        return exchange.getBody();
    }


    @Scheduled(fixedRate = 60 * 1000)
    public void clearcache() {
        Objects.requireNonNull(cacheManager.getCache("currentcycache")).clear();
    }

}