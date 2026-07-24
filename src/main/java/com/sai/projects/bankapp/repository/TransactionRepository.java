package com.sai.projects.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sai.projects.bankapp.model.Transaction;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountId(Long accountId);
}