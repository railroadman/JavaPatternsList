import com.example.designpatterns.creational.Singleton;
import com.example.designpatterns.creational.abstractfactory.AbstractFactoryDemo;
import com.example.designpatterns.creational.builder.BuilderDemo;
import com.example.designpatterns.creational.factorymethod.*;
import com.example.designpatterns.creational.prototype.PrototypeDemo;


import java.util.Scanner;

public class CreationalDesignPatternsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDesign Patterns Demo");
            System.out.println("1. Singleton");
            System.out.println("2. Factory Method");
            System.out.println("3. Abstract Factory");
            System.out.println("4. Builder");
            System.out.println("5. Prototype");
            System.out.println("0. Exit");
            System.out.print("Choose a pattern to demonstrate (0-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    demonstrateSingleton();
                    break;
                case 2:
                    demonstrateFactoryMethod();
                    break;
                case 3:
                    demonstrateAbstractFactory();
                    break;
                case 4:
                    demonstrateBuilder();
                    break;
                case 5:
                    demonstratePrototype();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void demonstrateSingleton() {
        System.out.println("\nDemonstrating Singleton Pattern");
        System.out.println("Package: com.example.designpatterns.creational.singleton");
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();

        Singleton anotherSingleton = Singleton.getInstance();
        System.out.println("Are both objects the same? " + (singleton == anotherSingleton));
    }

    private static void demonstrateFactoryMethod() {
        System.out.println("\nDemonstrating Factory Method Pattern");
        System.out.println("Package: com.example.designpatterns.creational.factorymethod");
        FactoryMethodDemo.runDemo();
    }

    private static void demonstrateAbstractFactory() {
        System.out.println("\nDemonstrating Abstract Factory Pattern");
        System.out.println("Package: com.example.designpatterns.creational.abstractfactory");
        AbstractFactoryDemo.runDemo();
    }

    private static void demonstrateBuilder() {
        System.out.println("\nDemonstrating Builder Pattern");
        System.out.println("Package: com.example.designpatterns.creational.builder");
        System.out.println("Example: Building different phone configurations");
        BuilderDemo.runDemo();
    }

    private static void demonstratePrototype() {
        System.out.println("\nDemonstrating Prototype Pattern");
        System.out.println("Package: com.example.designpatterns.creational.prototype");
        PrototypeDemo.runDemo();
    }
}