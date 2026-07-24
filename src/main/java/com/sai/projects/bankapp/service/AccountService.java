package com.sai.projects.bankapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sai.projects.bankapp.model.Account;
import com.sai.projects.bankapp.model.Transaction;
import com.sai.projects.bankapp.repository.AccountRepository;
import com.sai.projects.bankapp.repository.TransactionRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;
    
    @Autowired
    private TransactionRepository transactionRepo;
    

    public Account createAccount(Account account) {
        return repo.save(account);
    }

//    public Account deposit(Long id, double amount) {
//        Account acc = repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//
//        acc.setBalance(acc.getBalance() + amount);
//        return repo.save(acc);
//    }
    
    public Account deposit(Long id, double amount) {
        Account acc = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        acc.setBalance(acc.getBalance() + amount);
        repo.save(acc);

        // SAVE TRANSACTION
        Transaction tx = new Transaction(
                "DEPOSIT",
                amount,
                LocalDateTime.now(),
                acc
        );

        transactionRepo.save(tx);

        return acc;
    }

//    public Account withdraw(Long id, double amount) {
//        Account acc = repo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//
//        if (acc.getBalance() < amount) {
//            throw new RuntimeException("Insufficient Balance");
//        }
//
//        acc.setBalance(acc.getBalance() - amount);
//        return repo.save(acc);
//    }

    public Account withdraw(Long id, double amount) {
        Account acc = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        acc.setBalance(acc.getBalance() - amount);
        repo.save(acc);

        // SAVE TRANSACTION
        Transaction tx = new Transaction(
                "WITHDRAW",
                amount,
                LocalDateTime.now(),
                acc
        );

        transactionRepo.save(tx);

        return acc;
    }
    public double getBalance(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"))
                .getBalance();
    }
    
    @GetMapping("/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable Long id) {
        return transactionRepo.findByAccountId(id);
    }
}