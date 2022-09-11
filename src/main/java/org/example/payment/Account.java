package org.example.payment;

public class Account {
    private double balance;
    private PaymentMethod paymentMethod;
    private String name;

    public Account(String name) {
        this(name, 0.0, new Local());
    }

    public Account(String name, double balance) {
        this(name, balance, new Local());
    }

    public Account(String name, double balance, PaymentMethod paymentMethod) {
        this.balance = balance;
        this.paymentMethod = paymentMethod;
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.balance -= paymentMethod.calcCost(amount);
    }

    public void withdraw(double amount) {
        deposit(-amount);
    }

    public Object getName() {
        return this.name;
    }
}
