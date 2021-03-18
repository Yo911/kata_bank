package com.kata.bank;

import org.junit.jupiter.api.Test;

class BankOperationsTest {

    @Test
    void should_deposite_amount() {
        BankOperations operations = new BankOperations();

        operations.deposite(20.5);
    }

}