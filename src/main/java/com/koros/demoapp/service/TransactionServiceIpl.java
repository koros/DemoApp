package com.koros.demoapp.service;

import com.koros.demoapp.dto.Transaction;
import com.koros.demoapp.dto.TransactionList;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Setter
public class TransactionServiceIpl implements TransactionService {

    public static final String URL = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Transaction> getAll() {
        return makeHttpRequest(URL);
    }

    @Override
    public List<Transaction> filterByTransactionId(String transactionId) {
        List<Transaction> transactions = makeHttpRequest(URL);
        return transactions
                .stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .collect(Collectors.toList());
    }

    private List<Transaction> makeHttpRequest(String url) {
        ResponseEntity<TransactionList> response = restTemplate.getForEntity(url, TransactionList.class);
        return response.getBody().getTransactions();
    }
}
