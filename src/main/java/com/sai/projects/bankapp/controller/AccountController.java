	package com.sai.projects.bankapp.controller;
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;
	
	import com.sai.projects.bankapp.model.Account;
import com.sai.projects.bankapp.model.Transaction;
import com.sai.projects.bankapp.repository.TransactionRepository;
import com.sai.projects.bankapp.service.AccountService;
	
	@RestController
	@RequestMapping("/api/accounts")
	@CrossOrigin(origins = "*")
	public class AccountController {
	
	    @Autowired
	    private AccountService service;
	    
	    @Autowired
	    private TransactionRepository transactionRepo;

	    // Create Account
	    @PostMapping
	    public Account create(@RequestBody Account acc) {
	        return service.createAccount(acc);
	    }
	
	    // Deposit
	    @PostMapping("/{id}/deposit")
	    public Account deposit(@PathVariable Long id, @RequestParam double amount) {
	        return service.deposit(id, amount);
	    }
	
	    // Withdraw
	    @PostMapping("/{id}/withdraw")
	    public Account withdraw(@PathVariable Long id, @RequestParam double amount) {
	        return service.withdraw(id, amount);
	    }
	
	    // Get Balance
	    @GetMapping("/{id}/balance")
	    public double balance(@PathVariable Long id) {
	        return service.getBalance(id);
	    }
	    @GetMapping("/{id}/transactions")
	    public List<Transaction> getTransactions(@PathVariable Long id) {
	        return transactionRepo.findByAccountId(id);
	    }
	}