package com.koros.demoapp.service;

import com.koros.demoapp.dto.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
    List<Transaction> filterByTransactionId(String transactionId);
}
