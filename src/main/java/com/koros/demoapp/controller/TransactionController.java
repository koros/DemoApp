package com.koros.demoapp.controller;

import com.koros.demoapp.dto.Transaction;
import com.koros.demoapp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {

    private final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionService transactionService;

    @ResponseBody
    @GetMapping({"/transactions"})
    public List<Transaction> list(@RequestParam(name = "transaction_id", required = false) String transactionId) {
        log.info("get mapping for transactions called with param {}", transactionId);
        return transactionId == null ? transactionService.getAll() : transactionService.filterByTransactionId(transactionId);
    }

}
