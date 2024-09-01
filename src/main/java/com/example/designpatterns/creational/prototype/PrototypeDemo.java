package com.example.designpatterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

// Prototype
interface DocumentPrototype extends Cloneable {
    DocumentPrototype clone();
    void setContent(String content);
    String getContent();
}

// Concrete Prototype
class Document implements DocumentPrototype {
    private String name;
    private String content;

    public Document(String name) {
        this.name = name;
    }

    @Override
    public DocumentPrototype clone() {
        Document clonedDoc = new Document(this.name);
        clonedDoc.setContent(this.content);
        return clonedDoc;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return "Document: " + name + "\nContent: " + content;
    }
}

// Prototype Registry
class DocumentManager {
    private Map<String, DocumentPrototype> templates = new HashMap<>();

    public void addTemplate(String key, DocumentPrototype doc) {
        templates.put(key, doc);
    }

    public DocumentPrototype createDocument(String key) {
        DocumentPrototype template = templates.get(key);
        return template != null ? template.clone() : null;
    }
}

// Demo class
public class PrototypeDemo {
    public static void runDemo() {
        DocumentManager manager = new DocumentManager();

        // Create and register templates
        Document contractTemplate = new Document("Contract");
        contractTemplate.setContent("This is a standard contract template...");
        manager.addTemplate("contract", contractTemplate);

        Document reportTemplate = new Document("Report");
        reportTemplate.setContent("This is a standard report template...");
        manager.addTemplate("report", reportTemplate);

        // Create documents from templates
        DocumentPrototype contract1 = manager.createDocument("contract");
        contract1.setContent("This is a specific contract for Client A...");

        DocumentPrototype report1 = manager.createDocument("report");
        report1.setContent("This is a specific report for Project X...");

        // Print documents
        System.out.println(contract1.getContent());
        System.out.println("\n" + report1.getContent());

        // Create another contract
        DocumentPrototype contract2 = manager.createDocument("contract");
        contract2.setContent("This is a specific contract for Client B...");
        System.out.println("\n" + contract2.getContent());
    }
}