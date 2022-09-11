package org.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayPalTest {
    private PayPal payPal;
    private Account acc;

    @BeforeEach
    void setUp() {
        payPal = new PayPal();
        acc = new Account("testpaypalacc", 100.0, payPal);
    }

    @Test
    void calcCost() {
        double cost = payPal.calcCost(100.0);
        assertEquals(3.0, cost);
    }

    @Test
    void accountDeposit() {
        acc.deposit(100.0);
        double newBalance = acc.getBalance();
        assertEquals(197.0, newBalance);
    }

    @Test
    void accountWithdraw() {
        acc.withdraw(10.0);
        double newBalance = acc.getBalance();
        assertEquals(89.7, newBalance);
    }
}