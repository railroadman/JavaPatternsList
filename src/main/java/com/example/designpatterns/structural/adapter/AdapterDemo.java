package com.example.designpatterns.structural.adapter;

interface PaymentProcessor {
    void processPayment(double amount);
    void refundPayment(double amount);
}

// Existing implementation of PaymentProcessor
class ExistingPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through existing payment system");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println("Refunding payment of $" + amount + " through existing payment system");
    }
}

// New payment gateway with different interface
class NewPaymentGateway {
    public void makePayment(String amount) {
        System.out.println("Making payment of $" + amount + " through new payment gateway");
    }

    public void reverseTransaction(String amount) {
        System.out.println("Reversing transaction of $" + amount + " through new payment gateway");
    }
}

// Adapter to make NewPaymentGateway compatible with PaymentProcessor interface
class NewPaymentGatewayAdapter implements PaymentProcessor {
    private NewPaymentGateway newGateway;

    public NewPaymentGatewayAdapter(NewPaymentGateway newGateway) {
        this.newGateway = newGateway;
    }

    @Override
    public void processPayment(double amount) {
        newGateway.makePayment(String.valueOf(amount));
    }

    @Override
    public void refundPayment(double amount) {
        newGateway.reverseTransaction(String.valueOf(amount));
    }
}

// Demo class
public class AdapterDemo {
    public static void runDemo() {
        // Using the existing payment processor
        PaymentProcessor existingProcessor = new ExistingPaymentProcessor();
        System.out.println("Using existing payment processor:");
        existingProcessor.processPayment(100.00);
        existingProcessor.refundPayment(50.00);

        System.out.println();

        // Using the new payment gateway through the adapter
        NewPaymentGateway newGateway = new NewPaymentGateway();
        PaymentProcessor newProcessor = new NewPaymentGatewayAdapter(newGateway);
        System.out.println("Using new payment gateway through adapter:");
        newProcessor.processPayment(200.00);
        newProcessor.refundPayment(75.00);
    }
}