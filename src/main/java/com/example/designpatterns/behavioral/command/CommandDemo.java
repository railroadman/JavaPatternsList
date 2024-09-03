package com.example.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

// Receiver classes
class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " light is ON");
    }

    public void turnOff() {
        System.out.println(location + " light is OFF");
    }
}

class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Thermostat is set to " + temperature + " degrees");
    }
}

// Command interface
interface Command {
    void execute();
    void undo();
}

// Concrete Command classes
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temperature;

    public SetThermostatCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        thermostat.setTemperature(temperature);
    }

    @Override
    public void undo() {
        // For simplicity, we'll just set it back to a default temperature
        thermostat.setTemperature(20);
    }
}

// Invoker
class RemoteControl {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (Command command : commands) {
            command.execute();
        }
        commands.clear();
    }
}

// Client
public class CommandDemo {
    public static void main(String[] args) {
        // Create receivers
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Thermostat thermostat = new Thermostat();

        // Create commands
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        Command setThermostat = new SetThermostatCommand(thermostat, 22);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Use the invoker to execute commands
        System.out.println("--- Executing commands ---");
        remote.addCommand(livingRoomLightOn);
        remote.addCommand(kitchenLightOn);
        remote.addCommand(setThermostat);
        remote.executeCommands();

        System.out.println("\n--- Executing more commands ---");
        remote.addCommand(livingRoomLightOff);
        remote.addCommand(kitchenLightOff);
        remote.executeCommands();

        // Demonstrate undo
        System.out.println("\n--- Undoing a command ---");
        livingRoomLightOn.execute();
        livingRoomLightOn.undo();
    }
}