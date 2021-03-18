package com.kata.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankOperationsTest {

    @Test
    void should_deposite_amount() {
        BankOperations operations = new BankOperations(5.5);

        double deposite = operations.deposite(20.5);

        Assertions.assertEquals(20.5 + 5.5, deposite);
    }

}