package com.example.designpatterns.creational.factorymethod;

interface Vehicle {
    void drive();
}

// Concrete Products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a motorcycle...");
    }
}

// Creator
abstract class VehicleFactory {
    abstract Vehicle createVehicle();

    public void testDrive() {
        Vehicle vehicle = createVehicle();
        vehicle.drive();
    }
}

// Concrete Creators
class CarFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
class MotorcycleFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Motorcycle();
    }
}

// Demo class
public class FactoryMethodDemo {
    public static void runDemo() {
        VehicleFactory carFactory = new CarFactory();
        VehicleFactory motorcycleFactory = new MotorcycleFactory();

        System.out.println("Using Car Factory:");
        carFactory.testDrive();

        System.out.println("\nUsing Motorcycle Factory:");
        motorcycleFactory.testDrive();
    }
}