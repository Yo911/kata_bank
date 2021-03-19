package com.kata.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void should_deposite_amount_into_account() {
        Account account = new Account();

        account.deposite(25.1);

        Assertions.assertEquals(1, account.getAccountStatements().size());
        Assertions.assertEquals(25.1, account.getActualBalance());
    }

    @Test
    void should_deposite_multiple_amount_into_account() {
        Account account = new Account();

        account.deposite(50);
        account.deposite(100);

        Assertions.assertEquals(2, account.getAccountStatements().size());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(100, account.getAccountStatements().get(1).getAmount());
        Assertions.assertEquals(150, account.getAccountStatements().get(1).getBalance());
        Assertions.assertEquals(150, account.getActualBalance());
    }

    @Test
    void should_withdraw_amount_into_account() {
        Account account = new Account();

        account.withdraw(50);

        Assertions.assertEquals(1, account.getAccountStatements().size());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(-50, account.getActualBalance());
    }

    @Test
    void should_withdraw_multiple_amount_into_account() {
        Account account = new Account();

        account.withdraw(50);
        account.withdraw(450);

        Assertions.assertEquals(2, account.getAccountStatements().size());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(-450, account.getAccountStatements().get(1).getAmount());
        Assertions.assertEquals(-500, account.getAccountStatements().get(1).getBalance());
        Assertions.assertEquals(-500, account.getActualBalance());
    }

    @Test
    void should_deposite_and_withdraw_amount() {
        Account account = new Account();

        account.deposite(50);
        account.withdraw(49);

        Assertions.assertEquals(2, account.getAccountStatements().size());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(-49, account.getAccountStatements().get(1).getAmount());
        Assertions.assertEquals(1, account.getAccountStatements().get(1).getBalance());
        Assertions.assertEquals(1, account.getActualBalance());
    }
}
