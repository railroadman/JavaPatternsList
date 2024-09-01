import com.example.designpatterns.structural.adapter.AdapterDemo;
import com.example.designpatterns.structural.bridge.BridgeDemo;
import com.example.designpatterns.structural.composite.CompositeDemo;
import com.example.designpatterns.structural.decorator.DecoratorDemo;
import com.example.designpatterns.structural.facade.FacadeDemo;
import com.example.designpatterns.structural.flyweight.FlyweightDemo;
import com.example.designpatterns.structural.proxy.ProxyDemo;

import java.util.Scanner;

public class StructuralDesignPatternsDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to the Structural Design Patterns Demo!");
        System.out.println("This demo covers all seven main structural design patterns:");
        System.out.println("1. Adapter");
        System.out.println("2. Bridge");
        System.out.println("3. Composite");
        System.out.println("4. Decorator");
        System.out.println("5. Facade");
        System.out.println("6. Flyweight");
        System.out.println("7. Proxy");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStructural Design Patterns Demo");
            System.out.println("1. Adapter");
            System.out.println("2. Bridge");
            System.out.println("3. Composite");
            System.out.println("4. Decorator");
            System.out.println("5. Facade");
            System.out.println("6. Flyweight");
            System.out.println("7. Proxy");
            System.out.println("0. Exit");
            System.out.print("Choose a pattern to demonstrate (0-7): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    demonstrateAdapter();
                    break;
                case 2:
                    demonstrateBridge();
                    break;
                case 3:
                    demonstrateComposite();
                    break;
                case 4:
                    demonstrateDecorator();
                    break;
                case 5:
                    demonstrateFacade();
                    break;
                case 6:
                    demonstrateFlyweight();
                    break;
                case 7:
                    demonstrateProxy();
                    break;
                case 0:
                    System.out.println("Thank you for exploring the structural design patterns. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void demonstrateAdapter() {
        System.out.println("\nDemonstrating Adapter Pattern");
        System.out.println("Package: com.example.designpatterns.structural.adapter");
        AdapterDemo.runDemo();
    }

    private static void demonstrateBridge() {
        System.out.println("\nDemonstrating Bridge Pattern");
        System.out.println("Package: com.example.designpatterns.structural.bridge");
        BridgeDemo.runDemo();
    }

    private static void demonstrateComposite() {
        System.out.println("\nDemonstrating Composite Pattern");
        System.out.println("Package: com.example.designpatterns.structural.composite");
        CompositeDemo.runDemo();
    }

    private static void demonstrateDecorator() {
        System.out.println("\nDemonstrating Decorator Pattern");
        System.out.println("Package: com.example.designpatterns.structural.decorator");
        DecoratorDemo.runDemo();
    }

    private static void demonstrateFacade() {
        System.out.println("\nDemonstrating Facade Pattern");
        System.out.println("Package: com.example.designpatterns.structural.facade");
        FacadeDemo.runDemo();
    }

    private static void demonstrateFlyweight() {
        System.out.println("\nDemonstrating Flyweight Pattern");
        System.out.println("Package: com.example.designpatterns.structural.flyweight");
        FlyweightDemo.runDemo();
    }

    private static void demonstrateProxy() {
        System.out.println("\nDemonstrating Proxy Pattern");
        System.out.println("Package: com.example.designpatterns.structural.proxy");
        ProxyDemo.runDemo();
    }
}