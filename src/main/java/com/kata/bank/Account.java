package com.kata.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<AccountStatement> accountStatements = new ArrayList<>();

    public void deposite(double depositeAmount) {
        accountStatements.add(new AccountStatement(depositeAmount, getActualBalance() + depositeAmount));
    }

    public List<AccountStatement> getAccountStatements() {
        return accountStatements;
    }

    public double getActualBalance() {
        int sizeStatements = accountStatements.size();
        return sizeStatements == 0 ? 0 : accountStatements.get(sizeStatements - 1).getBalance();
    }

    public void withdraw(double withdrawAmount) {
        accountStatements.add(new AccountStatement(-withdrawAmount, getActualBalance() - withdrawAmount));
    }

    public void history() {
        accountStatements.forEach(AccountStatement::print);
    }
}
