package org.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account acc;

    @BeforeEach
    void setUp() {
        acc = new Account("testaccname", 100.0);
    }

    @Test
    public void newAccount() {
        Account acc = new Account("testaccname", 100.0);
        assertEquals(100.0, acc.getBalance());
    }

    @Test
    public void newAccount2() {
        Account acc = new Account("testaccname", 200.0);
        assertEquals(200.0, acc.getBalance());
    }


    @Test
    void getBalance() {
        double balance = acc.getBalance();
        assertEquals(100.0, balance);
    }

    @Test
    void deposit() {
        acc.deposit(50.0);
        double newBalance = acc.getBalance();
        assertEquals(150.0, newBalance);
    }

    @Test
    void withdraw() {
        acc.withdraw(50.0);
        double newBalance = acc.getBalance();
        assertEquals(50.0, newBalance);
    }
}