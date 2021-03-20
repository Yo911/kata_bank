package com.kata.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.spy;

public class AccountTest {

    @Test
    void should_deposite_amount_into_account() {
        // Given
        Account account = new Account();

        // When
        account.deposite(25.1);

        // Then
        Assertions.assertEquals(1, account.getAccountStatements().size());
        Assertions.assertEquals(25.1, account.getActualBalance());
    }

    @Test
    void should_deposite_multiple_amount_into_account() {
        // Given
        Account account = new Account();

        // When
        account.deposite(50);
        account.deposite(100);

        // Then
        Assertions.assertEquals(2, account.getAccountStatements().size());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(100, account.getAccountStatements().get(1).getAmount());
        Assertions.assertEquals(150, account.getAccountStatements().get(1).getBalance());
        Assertions.assertEquals(150, account.getActualBalance());
    }

    @Test
    void should_withdraw_amount_into_account() {
        // Given
        Account account = new Account();

        // When
        account.withdraw(50);

        // Then
        Assertions.assertEquals(1, account.getAccountStatements().size());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(-50, account.getActualBalance());
    }

    @Test
    void should_withdraw_multiple_amount_into_account() {
        // Given
        Account account = new Account();

        // When
        account.withdraw(50);
        account.withdraw(450);

        // Then
        Assertions.assertEquals(2, account.getAccountStatements().size());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(-50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(-450, account.getAccountStatements().get(1).getAmount());
        Assertions.assertEquals(-500, account.getAccountStatements().get(1).getBalance());
        Assertions.assertEquals(-500, account.getActualBalance());
    }

    @Test
    void should_deposite_and_withdraw_amount() {
        // Given
        Account account = new Account();

        // When
        account.deposite(50);
        account.withdraw(49);

        // Then
        Assertions.assertEquals(2, account.getAccountStatements().size());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getAmount());
        Assertions.assertEquals(50, account.getAccountStatements().get(0).getBalance());
        Assertions.assertEquals(-49, account.getAccountStatements().get(1).getAmount());
        Assertions.assertEquals(1, account.getAccountStatements().get(1).getBalance());
        Assertions.assertEquals(1, account.getActualBalance());
    }

    @Test
    void should_print_history() {
        // Given
        Account account = spy(new Account());

        AccountStatement statementDeposite = spy(new AccountStatement(50, 50));
        AccountStatement statementWithdrawal = spy(new AccountStatement(-49, 1));
        doAnswer(amountDeposite -> account.getAccountStatements().add(statementDeposite))
                .when(account).deposite(anyDouble());
        doAnswer(amountWithdraw -> account.getAccountStatements().add(statementWithdrawal)).when(account).withdraw(anyDouble());

        account.deposite(50);
        account.withdraw(49);

        // When
        account.history();

        // Then
        verify(statementDeposite).print();
        verify(statementWithdrawal).print();
    }
}
