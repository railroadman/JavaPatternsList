package com.example.designpatterns.structural.decorator;

// Component interface
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 1.0;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorators
class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5;
    }
}

class WhippedCream extends CoffeeDecorator {
    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7;
    }
}

class Vanilla extends CoffeeDecorator {
    public Vanilla(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Vanilla";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7;
    }
}

// Demo class
public class DecoratorDemo {
    public static void runDemo() {
        // Order a simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost: $" + coffee.getCost() + ", Description: " + coffee.getDescription());

        // Decorate it with milk
        Coffee milkCoffee = new Milk(coffee);
        System.out.println("Cost: $" + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());

        // Decorate it with whipped cream
        Coffee whippedCreamCoffee = new WhippedCream(milkCoffee);
        System.out.println("Cost: $" + whippedCreamCoffee.getCost() + ", Description: " + whippedCreamCoffee.getDescription());

        // Create a complex coffee with all decorators
        Coffee ultimateCoffee = new Vanilla(new WhippedCream(new Milk(new SimpleCoffee())));
        System.out.println("Cost: $" + ultimateCoffee.getCost() + ", Description: " + ultimateCoffee.getDescription());
    }
}