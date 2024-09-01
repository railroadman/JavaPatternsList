package com.example.designpatterns.structural.bridge;

// Implementor
interface PaymentSystem {
    void processPayment(double amount);
}

// Concrete Implementors
class PayPal implements PaymentSystem {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal");
    }
}

class Stripe implements PaymentSystem {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe");
    }
}

class BankTransfer implements PaymentSystem {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Bank Transfer");
    }
}

// Abstraction
abstract class Payment {
    protected PaymentSystem paymentSystem;

    public Payment(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    abstract void makePayment(double amount);
}

// Refined Abstractions
class RegularPayment extends Payment {
    public RegularPayment(PaymentSystem paymentSystem) {
        super(paymentSystem);
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Processing regular payment");
        paymentSystem.processPayment(amount);
    }
}

class InstallmentPayment extends Payment {
    private int installments;

    public InstallmentPayment(PaymentSystem paymentSystem, int installments) {
        super(paymentSystem);
        this.installments = installments;
    }

    @Override
    void makePayment(double amount) {
        double installmentAmount = amount / installments;
        System.out.println("Processing installment payment");
        System.out.println("Total amount: $" + amount + ", split into " + installments + " installments of $" + installmentAmount + " each");
        paymentSystem.processPayment(installmentAmount);
    }
}

class SubscriptionPayment extends Payment {
    private String interval;

    public SubscriptionPayment(PaymentSystem paymentSystem, String interval) {
        super(paymentSystem);
        this.interval = interval;
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Processing subscription payment");
        System.out.println("Amount: $" + amount + ", billed " + interval);
        paymentSystem.processPayment(amount);
    }
}

// Demo class
public class BridgeDemo {
    public static void runDemo() {
        PaymentSystem paypal = new PayPal();
        PaymentSystem stripe = new Stripe();
        PaymentSystem bankTransfer = new BankTransfer();

        Payment regularPaypal = new RegularPayment(paypal);
        Payment installmentStripe = new InstallmentPayment(stripe, 3);
        Payment subscriptionBank = new SubscriptionPayment(bankTransfer, "monthly");

        regularPaypal.makePayment(100.0);
        System.out.println();
        installmentStripe.makePayment(300.0);
        System.out.println();
        subscriptionBank.makePayment(50.0);
    }
}