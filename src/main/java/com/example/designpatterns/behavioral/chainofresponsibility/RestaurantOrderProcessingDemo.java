package com.example.designpatterns.behavioral.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

// OrderException class for handling errors
class OrderException extends Exception {
    private final String handlerName;

    public OrderException(String message, String handlerName) {
        super(message);
        this.handlerName = handlerName;
    }

    public String getHandlerName() {
        return handlerName;
    }
}

// Handler interface
interface OrderHandler {
    void setNext(OrderHandler handler);
    void processOrder(Order order) throws OrderException;
}

// Abstract handler
abstract class AbstractOrderHandler implements OrderHandler {
    protected OrderHandler nextHandler;
    protected String handlerName;

    public AbstractOrderHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void setNext(OrderHandler handler) {
        this.nextHandler = handler;
    }

    protected void passToNext(Order order) throws OrderException {
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        } else {
            System.out.println("Order processing completed.");
        }
    }
}

// Concrete handlers
class Waiter extends AbstractOrderHandler {
    public Waiter() {
        super("Waiter");
    }

    @Override
    public void processOrder(Order order) throws OrderException {
        System.out.println("Waiter is taking the order: " + order.getItems());
        if (order.getItems().isEmpty()) {
            throw new OrderException("Cannot process an empty order", handlerName);
        }
        passToNext(order);
    }
}

class Kitchen extends AbstractOrderHandler {
    public Kitchen() {
        super("Kitchen");
    }

    @Override
    public void processOrder(Order order) throws OrderException {
        System.out.println("Kitchen is checking ingredients availability...");
        boolean allIngredientsAvailable = Math.random() < 0.9; // 90% chance all ingredients are available
        if (allIngredientsAvailable) {
            System.out.println("All ingredients are available. Passing to the chef.");
            passToNext(order);
        } else {
            throw new OrderException("Some ingredients are missing", handlerName);
        }
    }
}

class Chef extends AbstractOrderHandler {
    public Chef() {
        super("Chef");
    }

    @Override
    public void processOrder(Order order) throws OrderException {
        System.out.println("Chef is preparing the dishes: " + order.getItems());
        try {
            Thread.sleep(3000); // 3 seconds cooking time
        } catch (InterruptedException e) {
            throw new OrderException("Cooking was interrupted", handlerName);
        }
        System.out.println("Dishes are prepared.");
        passToNext(order);
    }
}

class QualityCheck extends AbstractOrderHandler {
    public QualityCheck() {
        super("Quality Check");
    }

    @Override
    public void processOrder(Order order) throws OrderException {
        System.out.println("Head chef is checking the quality of dishes...");
        boolean qualityOk = Math.random() < 0.95; // 95% chance quality is good
        if (qualityOk) {
            System.out.println("Quality check passed. Order is ready for serving.");
            passToNext(order);
        } else {
            throw new OrderException("Quality check failed", handlerName);
        }
    }
}

class Server extends AbstractOrderHandler {
    public Server() {
        super("Server");
    }

    @Override
    public void processOrder(Order order) throws OrderException {
        System.out.println("Server is delivering the order to the customer.");
        System.out.println("Order served: " + order.getItems());
    }
}

// Order class
class Order {
    private List<String> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}

// Demo
public class RestaurantOrderProcessingDemo {
    public static void main(String[] args) {
        // Create the chain of responsibility
        OrderHandler waiter = new Waiter();
        OrderHandler kitchen = new Kitchen();
        OrderHandler chef = new Chef();
        OrderHandler qualityCheck = new QualityCheck();
        OrderHandler server = new Server();

        waiter.setNext(kitchen);
        kitchen.setNext(chef);
        chef.setNext(qualityCheck);
        qualityCheck.setNext(server);

        // Create an order
        Order order = new Order();
        order.addItem("Steak");
        order.addItem("Salad");
        order.addItem("Wine");

        // Process the order
        System.out.println("Processing new order...");
        try {
            waiter.processOrder(order);
            System.out.println("Order processed successfully!");
        } catch (OrderException e) {
            System.out.println("Error occurred during order processing:");
            System.out.println("Stage: " + e.getHandlerName());
            System.out.println("Error: " + e.getMessage());
        }

        // Example of an empty order
        System.out.println("\nProcessing an empty order...");
        Order emptyOrder = new Order();
        try {
            waiter.processOrder(emptyOrder);
        } catch (OrderException e) {
            System.out.println("Error occurred during order processing:");
            System.out.println("Stage: " + e.getHandlerName());
            System.out.println("Error: " + e.getMessage());
        }
    }
}