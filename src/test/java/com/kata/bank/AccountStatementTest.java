package com.kata.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

class AccountStatementTest {

    @Test
    void should_print_account_statement() {
        AccountStatement account = new AccountStatement(new BigDecimal(5), new BigDecimal(9));

        String expected = "date: " + account.getDate() + " amount: " + account.getAmount() + " balance: " + account.getBalance();
        Assertions.assertEquals(expected, account.print());
    }

}