package com.kata.bank;

public class BankOperations {

    private double actualBalance;

    public BankOperations(double actualBalance) {
        this.actualBalance = actualBalance;
    }

    public double deposite(double depositeAmount) {
        actualBalance += depositeAmount;
        return actualBalance;
    }
}
