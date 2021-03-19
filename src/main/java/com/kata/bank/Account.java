package com.kata.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<AccountStatement> accountStatements = new ArrayList<>();

    public void deposite(double depositeAmount) {
        AccountStatement accountStatement = new AccountStatement(depositeAmount, getActualBalance() + depositeAmount);
        accountStatements.add(accountStatement);
    }

    public List<AccountStatement> getAccountStatements() {
        return accountStatements;
    }

    public double getActualBalance() {
        int sizeStatements = accountStatements.size();
        return sizeStatements == 0 ? 0 : accountStatements.get(sizeStatements - 1).getBalance();
    }
}
