package com.example.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// Flyweight
interface CharacterFlyweight {
    void display(int fontSize);
}

// Concrete Flyweight
class ConcreteCharacter implements CharacterFlyweight {
    private char symbol;

    public ConcreteCharacter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int fontSize) {
        System.out.println("Character " + symbol + " with font size " + fontSize);
    }
}

// Flyweight Factory
class CharacterFactory {
    private Map<Character, CharacterFlyweight> characters = new HashMap<>();

    public CharacterFlyweight getCharacter(char symbol) {
        Character key = Character.valueOf(symbol);
        if (!characters.containsKey(key)) {
            characters.put(key, new ConcreteCharacter(symbol));
        }
        return characters.get(key);
    }

    public int getTotalCharacters() {
        return characters.size();
    }
}

// Context
class TextEditor {
    private CharacterFactory characterFactory;
    private List<CharacterFlyweight> characters = new ArrayList<>();
    private List<Integer> fontSizes = new ArrayList<>();

    public TextEditor(CharacterFactory characterFactory) {
        this.characterFactory = characterFactory;
    }

    public void addCharacter(char symbol, int fontSize) {
        characters.add(characterFactory.getCharacter(symbol));
        fontSizes.add(fontSize);
    }

    public void display() {
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).display(fontSizes.get(i));
        }
    }
}

// Demo class
public class FlyweightDemo {
    public static void runDemo() {
        CharacterFactory factory = new CharacterFactory();
        TextEditor editor = new TextEditor(factory);

        String text = "Hello, Flyweight Pattern!";
        for (char c : text.toCharArray()) {
            editor.addCharacter(c, 12); // Assuming font size 12 for all characters
        }

        System.out.println("Text in editor:");
        editor.display();

        System.out.println("\nTotal CharacterFlyweight objects created: " + factory.getTotalCharacters());
    }
}