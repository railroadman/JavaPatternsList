import com.example.designpatterns.behavioral.chainofresponsibility.RestaurantOrderProcessingDemo;
import com.example.designpatterns.behavioral.command.CommandDemo;

import java.util.Scanner;

public class BehavioralDesignPatternsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBehavioral Design Patterns Demo");
            System.out.println("1. Chain of Responsibility");
            System.out.println("2. Command");
            System.out.println("3. Interpreter");
            System.out.println("4. Iterator");
            System.out.println("5. Mediator");
            System.out.println("6. Memento");
            System.out.println("7. Observer");
            System.out.println("8. State");
            System.out.println("9. Strategy");
            System.out.println("10. Template Method");
            System.out.println("11. Visitor");
            System.out.println("0. Exit");
            System.out.print("Choose a pattern to demonstrate (0-11): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    demonstrateChainOfResponsibility();
                    break;
                case 2:
                    demonstrateCommand();
                    break;
                case 3:
                    demonstrateInterpreter();
                    break;
                case 4:
                    demonstrateIterator();
                    break;
                case 5:
                    demonstrateMediator();
                    break;
                case 6:
                    demonstrateMemento();
                    break;
                case 7:
                    demonstrateObserver();
                    break;
                case 8:
                    demonstrateState();
                    break;
                case 9:
                    demonstrateStrategy();
                    break;
                case 10:
                    demonstrateTemplateMethod();
                    break;
                case 11:
                    demonstrateVisitor();
                    break;
                case 0:
                    System.out.println("Thank you for exploring the behavioral design patterns. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void demonstrateChainOfResponsibility() {
        System.out.println("\nDemonstrating Chain of Responsibility Pattern");
        System.out.println("Example: Restaurant Order Processing");
        RestaurantOrderProcessingDemo.main(null);
    }

    private static void demonstrateCommand() {
        System.out.println("\nDemonstrating Command Pattern");
        System.out.println("Example: Smart Home Control System");
        CommandDemo.main(null);
    }

    private static void demonstrateInterpreter() {
        System.out.println("\nDemonstrating Interpreter Pattern");
        System.out.println("Not implemented yet");
        // InterpreterDemo.main(null);
    }

    private static void demonstrateIterator() {
        System.out.println("\nDemonstrating Iterator Pattern");
        System.out.println("Not implemented yet");
        // IteratorDemo.main(null);
    }

    private static void demonstrateMediator() {
        System.out.println("\nDemonstrating Mediator Pattern");
        System.out.println("Not implemented yet");
        // MediatorDemo.main(null);
    }

    private static void demonstrateMemento() {
        System.out.println("\nDemonstrating Memento Pattern");
        System.out.println("Not implemented yet");
        // MementoDemo.main(null);
    }

    private static void demonstrateObserver() {
        System.out.println("\nDemonstrating Observer Pattern");
        System.out.println("Not implemented yet");
        // ObserverDemo.main(null);
    }

    private static void demonstrateState() {
        System.out.println("\nDemonstrating State Pattern");
        System.out.println("Not implemented yet");
        // StateDemo.main(null);
    }

    private static void demonstrateStrategy() {
        System.out.println("\nDemonstrating Strategy Pattern");
        System.out.println("Not implemented yet");
        // StrategyDemo.main(null);
    }

    private static void demonstrateTemplateMethod() {
        System.out.println("\nDemonstrating Template Method Pattern");
        System.out.println("Not implemented yet");
        // TemplateMethodDemo.main(null);
    }

    private static void demonstrateVisitor() {
        System.out.println("\nDemonstrating Visitor Pattern");
        System.out.println("Not implemented yet");
        // VisitorDemo.main(null);
    }
}