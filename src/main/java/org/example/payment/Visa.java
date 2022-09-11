package org.example.payment;

import static java.lang.Math.abs;

public class Visa implements PaymentMethod {
    @Override
    public double calcCost(double amount) {
        return abs(amount)*0.05; // fünf prozent
    }
}
