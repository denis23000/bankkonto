package org.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SEPATest {
    private SEPA sepa;
    private Account acc;

    @BeforeEach
    void setUp() {
        sepa = new SEPA();
        acc = new Account("testsepaacc", 1000.0, sepa);
    }

    @Test
    void calcCostUnder100() {
        double cost = sepa.calcCost(99.9);
        assertEquals(0.0, cost);
    }

    @Test
    void calcCostOver100() {
        double cost = sepa.calcCost(200.0);
        assertEquals(8.0, cost);
    }

    @Test
    void calcCostMax400() {
        double cost = sepa.calcCost(2000000.0);
        assertEquals(400.0, cost);
    }

    @Test
    void withdraw() {
        acc.withdraw(200.0);
        double newBalance = acc.getBalance();
        assertEquals(792.0, newBalance);
    }

}