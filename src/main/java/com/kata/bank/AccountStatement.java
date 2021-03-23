package com.kata.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountStatement {

    private final LocalDateTime date;

    private final BigDecimal amount;

    private final BigDecimal balance;

    public AccountStatement(BigDecimal amount, BigDecimal balance) {
        this.date = LocalDateTime.now();
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String print() {
        return "date: " + date + " amount: " + amount + " balance: " + balance;
    }
}
