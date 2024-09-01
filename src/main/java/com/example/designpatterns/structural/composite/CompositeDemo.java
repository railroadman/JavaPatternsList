package com.example.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Component
interface Employee {
    void showDetails();
    double getSalary();
}

// Leaf
class Developer implements Employee {
    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + ", Salary: $" + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}

// Leaf
class Designer implements Employee {
    private String name;
    private double salary;

    public Designer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Designer: " + name + ", Salary: $" + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
}

// Composite
class Department implements Employee {
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        System.out.println("Employees in " + name + ":");
        for (Employee employee : employees) {
            employee.showDetails();
        }
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }
}

// Demo class
public class CompositeDemo {
    public static void runDemo() {
        Developer dev1 = new Developer("John Doe", 120000);
        Developer dev2 = new Developer("Jane Smith", 115000);
        Designer designer1 = new Designer("Mike Johnson", 100000);

        Department engineeringDept = new Department("Engineering");
        engineeringDept.addEmployee(dev1);
        engineeringDept.addEmployee(dev2);

        Department designDept = new Department("Design");
        designDept.addEmployee(designer1);

        Department company = new Department("XYZ Corp");
        company.addEmployee(engineeringDept);
        company.addEmployee(designDept);

        System.out.println("Company Structure:");
        company.showDetails();

        System.out.println("\nTotal Salary Budget: $" + company.getSalary());
    }
}