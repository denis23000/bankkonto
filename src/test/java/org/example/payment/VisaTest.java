package org.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisaTest {
    private Visa visa;
    private Account acc;

    @BeforeEach
    void setUp() {
        visa = new Visa();
        acc = new Account("testvisaacc", 100.0, visa);
    }

    @Test
    void calcCost() {
        double cost = visa.calcCost(100.0);
        assertEquals(5.0, cost);
    }

    @Test
    void accountDeposit() {
        acc.deposit(100.0);
        double newBalance = acc.getBalance();
        assertEquals(195.0, newBalance);
    }

    @Test
    void accountWithdraw() {
        acc.withdraw(10.0);
        double newBalance = acc.getBalance();
        assertEquals(89.5, newBalance);
    }
}