
package com.sai.projects.bankapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // DEPOSIT / WITHDRAW

    private double amount;

    private LocalDateTime timestamp;

    // Many transactions belong to one account
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Constructors
    public Transaction() {}

    public Transaction(String type, double amount, LocalDateTime timestamp, Account account) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.account = account;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}