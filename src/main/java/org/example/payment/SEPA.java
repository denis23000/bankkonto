package org.example.payment;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class SEPA implements PaymentMethod {
    public double calcCost(double amount) {
        double cost;
        amount = abs(amount);
        if(amount<100.0) {
            cost = 0.0;
        } else {
            cost = amount*0.04;
        }
        cost = min(400.0, cost);
        return cost;
    }
}
