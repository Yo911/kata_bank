package com.kata.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private List<AccountStatement> accountStatements = new ArrayList<>();

    public void deposite(double depositeAmount) {
        if (depositeAmount < 0) {
            throw new IllegalArgumentException("you cannot deposite negative amount");
        }
        BigDecimal updatedActualBalance = new BigDecimal(getActualBalance().doubleValue() + depositeAmount);
        accountStatements.add(new AccountStatement(new BigDecimal(depositeAmount), updatedActualBalance));
    }

    public List<AccountStatement> getAccountStatements() {
        return accountStatements;
    }

    public BigDecimal getActualBalance() {
        int sizeStatements = accountStatements.size();
        return sizeStatements == 0 ? new BigDecimal(0) : accountStatements.get(sizeStatements - 1).getBalance();
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount < 0) {
            throw new IllegalArgumentException("you cannot withdraw negative amount");
        }
        BigDecimal updatedActualBalance = new BigDecimal(getActualBalance().doubleValue() - withdrawAmount);
        accountStatements.add(new AccountStatement(new BigDecimal(-withdrawAmount), updatedActualBalance));
    }

    public void history() {
        accountStatements.forEach(AccountStatement::print);
    }
}
