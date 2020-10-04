package com.koros.demoapp.controller;

import com.koros.demoapp.dto.Transaction;
import com.koros.demoapp.service.TransactionService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;

public class TransactionControllerTest {

    @Mock
    TransactionService transactionService;

    TransactionController transactionController;

    @BeforeEach
    public void setup(){
        transactionService = Mockito.mock(TransactionService.class);
        transactionController = new TransactionController(transactionService);
    }

    @Test
    public void shouldListTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setAccountid("11111");
        transaction.setCounterpartyAccount("test account 111");
        transactions.add(transaction);
        Transaction transaction2 = new Transaction();
        transaction2.setAccountid("2222");
        transaction2.setCounterpartyAccount("test account 222");
        transactions.add(transaction2);
        Mockito.when(transactionService.getAll()).thenReturn(transactions);
        List<Transaction> resp = transactionController.list(null);
        Assert.assertTrue(resp.size() == 2);
    }

    @Test
    public void shouldFilterTransactionsById(){
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        transaction.setAccountid("111111222222");
        transaction.setCounterpartyAccount("Test account 123");
        transactions.add(transaction);
        Mockito.when(transactionService.filterByTransactionId("1234")).thenReturn(transactions);
        List<Transaction> resp = transactionController.list("1234");
        Assert.assertTrue(resp.size() == 1);
    }

}
