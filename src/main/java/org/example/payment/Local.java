package org.example.payment;

public class Local implements PaymentMethod{

    @Override
    public double calcCost(double amount) {
        return 0.0;
    }
}
