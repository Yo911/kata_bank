package com.kata.bank;

import java.math.BigDecimal;
import java.util.Date;

public class AccountStatement {

    private final Date date;

    private final BigDecimal amount;

    private final BigDecimal balance;

    public AccountStatement(BigDecimal amount, BigDecimal balance) {
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
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
