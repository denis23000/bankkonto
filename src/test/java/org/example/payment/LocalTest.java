package org.example.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalTest {

    private Local pmLocal;

    @BeforeEach
    void setUp() {
        pmLocal = new Local();
    }

    @Test
    void calcCost() {
        double cost = pmLocal.calcCost(100.0);
        assertEquals(0.0, cost);
    }
}