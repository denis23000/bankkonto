package org.example.payment;

import static java.lang.Math.abs;

public class PayPal implements PaymentMethod {
    @Override
    public double calcCost(double amount) {
        return abs(amount)*0.03; // drei prozent
    }
}
