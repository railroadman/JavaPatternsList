# Structural Design Patterns

In this project, we have implemented seven core structural design patterns. Below is a brief description of each pattern, an implementation example, and a diagram.

## 1. Adapter

**Description:** The Adapter pattern allows objects with incompatible interfaces to work together.

**Implementation Example:** We created an adapter to integrate a new payment gateway into an existing payment processing system.

**Diagram:**

```mermaid
classDiagram
    class PaymentProcessor {
        <<interface>>
        +processPayment(amount: double)
        +refundPayment(amount: double)
    }
    class ExistingPaymentProcessor {
        +processPayment(amount: double)
        +refundPayment(amount: double)
    }
    class NewPaymentGateway {
        +makePayment(amount: String)
        +reverseTransaction(amount: String)
    }
    class NewPaymentGatewayAdapter {
        -newGateway: NewPaymentGateway
        +processPayment(amount: double)
        +refundPayment(amount: double)
    }
    PaymentProcessor <|.. ExistingPaymentProcessor
    PaymentProcessor <|.. NewPaymentGatewayAdapter
    NewPaymentGatewayAdapter --> NewPaymentGateway
```

## 2. Bridge

**Description:** The Bridge pattern separates abstraction from implementation, allowing them to vary independently.

**Implementation Example:** We created a system for different types of payments (regular, installment, subscription) and various payment systems (PayPal, Stripe, bank transfer).

**Diagram:**

```mermaid
classDiagram
    class Payment {
        <<abstract>>
        -paymentSystem: PaymentSystem
        +makePayment(amount: double)*
    }
    class PaymentSystem {
        <<interface>>
        +processPayment(amount: double)
    }
    class RegularPayment {
        +makePayment(amount: double)
    }
    class InstallmentPayment {
        +makePayment(amount: double)
    }
    class PayPal {
        +processPayment(amount: double)
    }
    class Stripe {
        +processPayment(amount: double)
    }
    Payment <|-- RegularPayment
    Payment <|-- InstallmentPayment
    Payment o--> PaymentSystem
    PaymentSystem <|.. PayPal
    PaymentSystem <|.. Stripe
```

## 3. Composite

**Description:** The Composite pattern allows clients to treat individual objects and compositions of objects uniformly.

**Implementation Example:** We created a company structure with departments and employees, where both individual employees and entire departments implement a common interface.

**Diagram:**

```mermaid
classDiagram
    class Employee {
        <<interface>>
        +showDetails()
        +getSalary(): double
    }
    class Developer {
        -name: String
        -salary: double
        +showDetails()
        +getSalary(): double
    }
    class Designer {
        -name: String
        -salary: double
        +showDetails()
        +getSalary(): double
    }
    class Department {
        -name: String
        -employees: List<Employee>
        +addEmployee(employee: Employee)
        +removeEmployee(employee: Employee)
        +showDetails()
        +getSalary(): double
    }
    Employee <|.. Developer
    Employee <|.. Designer
    Employee <|.. Department
    Department o--> Employee
```

## 4. Decorator

**Description:** The Decorator pattern adds new functionality to an object dynamically without altering its structure.

**Implementation Example:** We created a system for a coffee shop where a basic coffee can be enhanced with various ingredients (milk, whipped cream, vanilla).

**Diagram:**

```mermaid
classDiagram
    class Coffee {
        <<interface>>
        +getDescription(): String
        +getCost(): double
    }
    class SimpleCoffee {
        +getDescription(): String
        +getCost(): double
    }
    class CoffeeDecorator {
        <<abstract>>
        -decoratedCoffee: Coffee
        +getDescription(): String
        +getCost(): double
    }
    class Milk {
        +getDescription(): String
        +getCost(): double
    }
    class WhippedCream {
        +getDescription(): String
        +getCost(): double
    }
    Coffee <|.. SimpleCoffee
    Coffee <|.. CoffeeDecorator
    CoffeeDecorator <|-- Milk
    CoffeeDecorator <|-- WhippedCream
    CoffeeDecorator o--> Coffee
```

## 5. Facade

**Description:** The Facade pattern provides a unified interface to a set of interfaces in a subsystem.

**Implementation Example:** We created a facade for managing a home theater system, which simplifies the interaction with various devices (projector, sound system, lighting, etc.).

**Diagram:**

```mermaid
classDiagram
    class HomeTheaterFacade {
        -projector: Projector
        -soundSystem: SoundSystem
        -lights: Lights
        -screen: Screen
        -streamingPlayer: StreamingPlayer
        +watchMovie(movie: String)
        +endMovie()
    }
    class Projector {
        +turnOn()
        +turnOff()
        +setInput(input: String)
    }
    class SoundSystem {
        +turnOn()
        +turnOff()
        +setVolume(volume: int)
    }
    class Lights {
        +dim()
        +brighten()
    }
    class Screen {
        +lower()
        +raise()
    }
    class StreamingPlayer {
        +turnOn()
        +turnOff()
        +play(movie: String)
    }
    HomeTheaterFacade --> Projector
    HomeTheaterFacade --> SoundSystem
    HomeTheaterFacade --> Lights
    HomeTheaterFacade --> Screen
    HomeTheaterFacade --> StreamingPlayer
```

## 6. Flyweight

**Description:** The Flyweight pattern uses sharing to support a large number of fine-grained objects efficiently.

**Implementation Example:** We created a text editor where each character is represented by a separate object, but objects for identical characters are shared.

**Diagram:**

```mermaid
classDiagram
    class CharacterFlyweight {
        <<interface>>
        +display(fontSize: int)
    }
    class ConcreteCharacter {
        -symbol: char
        +display(fontSize: int)
    }
    class CharacterFactory {
        -characters: Map<Character, CharacterFlyweight>
        +getCharacter(symbol: char): CharacterFlyweight
        +getTotalCharacters(): int
    }
    class TextEditor {
        -characterFactory: CharacterFactory
        -characters: List<CharacterFlyweight>
        -fontSizes: List<Integer>
        +addCharacter(symbol: char, fontSize: int)
        +display()
    }
    CharacterFlyweight <|.. ConcreteCharacter
    CharacterFactory --> CharacterFlyweight
    TextEditor --> CharacterFactory
    TextEditor --> CharacterFlyweight
```

## 7. Proxy

**Description:** The Proxy pattern provides a surrogate or placeholder for another object to control access to it.

**Implementation Example:** We created a proxy for a video service that controls access based on user roles, and also implemented an example using Spring AOP to measure method execution time.

**Diagram for simple Proxy:**

```mermaid
classDiagram
    class VideoService {
        <<interface>>
        +playVideo(videoId: String)
    }
    class RealVideoService {
        +playVideo(videoId: String)
    }
    class VideoServiceProxy {
        -realVideoService: RealVideoService
        -userRole: String
        +playVideo(videoId: String)
    }
    VideoService <|.. RealVideoService
    VideoService <|.. VideoServiceProxy
    VideoServiceProxy --> RealVideoService
```

**Diagram for Spring AOP Proxy:**

```mermaid
classDiagram
    class UserService {
        <<interface>>
        +createUser(username: String)
        +updateUser(username: String)
    }
    class UserServiceImpl {
        +createUser(username: String)
        +updateUser(username: String)
    }
    class PerformanceAspect {
        +measureExecutionTime(joinPoint: ProceedingJoinPoint): Object
    }
    UserService <|.. UserServiceImpl
    UserServiceImpl <.. PerformanceAspect : proxies
```

These implementations demonstrate the application of structural design patterns in various scenarios, showcasing their flexibility and usefulness in solving different software design problems.