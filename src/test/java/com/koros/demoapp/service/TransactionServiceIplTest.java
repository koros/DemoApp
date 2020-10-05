package com.koros.demoapp.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.koros.demoapp.Constants;
import com.koros.demoapp.dto.Transaction;
import com.koros.demoapp.dto.TransactionList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionServiceIplTest {

    RestTemplate restTemplate;

    TransactionServiceIpl transactionServiceIpl = new TransactionServiceIpl();

    @Before
    public void setUp() throws Exception {
        restTemplate = Mockito.mock(RestTemplate.class);
        transactionServiceIpl.setRestTemplate(restTemplate);
    }

    @Test
    public void getAll() throws IOException {
        TransactionList transactionList = getDummyTransactions();
        assertEquals(3, transactionList.getTransactions().size());
        ResponseEntity<TransactionList> response = ResponseEntity.ok(transactionList);
        Mockito.when(restTemplate.getForEntity(TransactionServiceIpl.URL, TransactionList.class)).thenReturn(response);
        List<Transaction> resp = transactionServiceIpl.getAll();
        assertEquals(resp.size(), transactionList.getTransactions().size());
    }

    @Test
    public void filterByTransactionId() throws IOException {
        TransactionList transactionList = getDummyTransactions();
        assertEquals(3, transactionList.getTransactions().size());
        ResponseEntity<TransactionList> response = ResponseEntity.ok(transactionList);
        Mockito.when(restTemplate.getForEntity(TransactionServiceIpl.URL, TransactionList.class)).thenReturn(response);

        Transaction example = transactionList.getTransactions().get(0);

        List<Transaction> resp = transactionServiceIpl.filterByTransactionId(example.getId());
        assertEquals(1, resp.size());
        assertEquals(example.getAccountid(), resp.get(0).getAccountid());
    }

    private TransactionList getDummyTransactions() throws IOException {
        String json = Constants.TRANSACTIONS_JSON;
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TransactionList transactionList = mapper.readValue(json, TransactionList.class);
        return transactionList;
    }
}