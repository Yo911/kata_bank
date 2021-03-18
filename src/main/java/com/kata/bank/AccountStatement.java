package com.kata.bank;

import java.util.Date;

public class AccountStatement {

    private final Date date;

    private final double amount;

    private final double balance;

    public AccountStatement(double amount, double balance) {
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public String print() {
        return "date: " + date + " amount: " + amount + " balance: " + balance;
    }
}
