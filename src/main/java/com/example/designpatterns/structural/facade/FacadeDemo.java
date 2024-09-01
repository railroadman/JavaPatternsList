package com.example.designpatterns.structural.facade;

// Subsystem classes
class Projector {
    void turnOn() { System.out.println("Projector is on"); }
    void turnOff() { System.out.println("Projector is off"); }
    void setInput(String input) { System.out.println("Setting projector input to " + input); }
}

class SoundSystem {
    void turnOn() { System.out.println("Sound system is on"); }
    void turnOff() { System.out.println("Sound system is off"); }
    void setVolume(int volume) { System.out.println("Setting volume to " + volume); }
}

class Lights {
    void dim() { System.out.println("Lights are dimmed"); }
    void brighten() { System.out.println("Lights are brightened"); }
}

class Screen {
    void lower() { System.out.println("Screen is lowered"); }
    void raise() { System.out.println("Screen is raised"); }
}

class StreamingPlayer {
    void turnOn() { System.out.println("Streaming player is on"); }
    void turnOff() { System.out.println("Streaming player is off"); }
    void play(String movie) { System.out.println("Playing " + movie); }
}

// Facade
class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;
    private Screen screen;
    private StreamingPlayer streamingPlayer;

    public HomeTheaterFacade(Projector projector, SoundSystem soundSystem, Lights lights, Screen screen, StreamingPlayer streamingPlayer) {
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
        this.screen = screen;
        this.streamingPlayer = streamingPlayer;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        lights.dim();
        screen.lower();
        projector.turnOn();
        projector.setInput("streaming");
        soundSystem.turnOn();
        soundSystem.setVolume(10);
        streamingPlayer.turnOn();
        streamingPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        streamingPlayer.turnOff();
        soundSystem.turnOff();
        projector.turnOff();
        screen.raise();
        lights.brighten();
    }
}

// Demo class
public class FacadeDemo {
    public static void runDemo() {
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();
        Screen screen = new Screen();
        StreamingPlayer streamingPlayer = new StreamingPlayer();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem, lights, screen, streamingPlayer);

        System.out.println("--- Starting movie night ---");
        homeTheater.watchMovie("Inception");
        System.out.println("\n--- Ending movie night ---");
        homeTheater.endMovie();
    }
}