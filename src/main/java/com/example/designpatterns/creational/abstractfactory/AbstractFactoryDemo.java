package com.example.designpatterns.creational.abstractfactory;


// Abstract Products
interface Burger {
    String getDescription();
}

interface Drink {
    String getDescription();
}

interface Dessert {
    String getDescription();
}

// Concrete Products for USA
class BigMac implements Burger {
    public String getDescription() {
        return "Big Mac";
    }
}

class CocaCola implements Drink {
    public String getDescription() {
        return "Coca-Cola";
    }
}

class ApplePie implements Dessert {
    public String getDescription() {
        return "Apple Pie";
    }
}

// Concrete Products for Japan
class TeriyakiBurger implements Burger {
    public String getDescription() {
        return "Teriyaki Burger";
    }
}

class GreenTeaLatte implements Drink {
    public String getDescription() {
        return "Green Tea Latte";
    }
}

class MatChaSundae implements Dessert {
    public String getDescription() {
        return "Matcha Sundae";
    }
}

// Abstract Factory
interface McDonaldsFactory {
    Burger createBurger();
    Drink createDrink();
    Dessert createDessert();
}

// Concrete Factories
class USAMcDonaldsFactory implements McDonaldsFactory {
    public Burger createBurger() {
        return new BigMac();
    }
    public Drink createDrink() {
        return new CocaCola();
    }
    public Dessert createDessert() {
        return new ApplePie();
    }
}

class JapanMcDonaldsFactory implements McDonaldsFactory {
    public Burger createBurger() {
        return new TeriyakiBurger();
    }
    public Drink createDrink() {
        return new GreenTeaLatte();
    }
    public Dessert createDessert() {
        return new MatChaSundae();
    }
}

// Client
class McDonaldsRestaurant {
    private McDonaldsFactory factory;

    public McDonaldsRestaurant(McDonaldsFactory factory) {
        this.factory = factory;
    }

    public void orderMeal() {
        Burger burger = factory.createBurger();
        Drink drink = factory.createDrink();
        Dessert dessert = factory.createDessert();

        System.out.println("Your order:");
        System.out.println("Burger: " + burger.getDescription());
        System.out.println("Drink: " + drink.getDescription());
        System.out.println("Dessert: " + dessert.getDescription());
    }
}

// Demo class
public class AbstractFactoryDemo {
    public static void runDemo() {
        System.out.println("Ordering in USA McDonald's:");
        McDonaldsRestaurant usaRestaurant = new McDonaldsRestaurant(new USAMcDonaldsFactory());
        usaRestaurant.orderMeal();

        System.out.println("\nOrdering in Japan McDonald's:");
        McDonaldsRestaurant japanRestaurant = new McDonaldsRestaurant(new JapanMcDonaldsFactory());
        japanRestaurant.orderMeal();
    }
}