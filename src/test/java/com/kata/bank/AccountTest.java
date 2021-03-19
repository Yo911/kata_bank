package com.kata.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void should_deposite_amount_into_account() {
        Account account = new Account();

        account.deposite(25.1);

        Assertions.assertEquals(1, account.getAccountStatements().size());
        Assertions.assertEquals(25.1, account.getBalance());
    }
}
