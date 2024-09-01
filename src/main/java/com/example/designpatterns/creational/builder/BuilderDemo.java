package com.example.designpatterns.creational.builder;

// Product
class Phone {
    private String model;
    private String processor;
    private String memory;
    private String camera;
    private String battery;
    private String specialFeature;

    public void setModel(String model) { this.model = model; }
    public void setProcessor(String processor) { this.processor = processor; }
    public void setMemory(String memory) { this.memory = memory; }
    public void setCamera(String camera) { this.camera = camera; }
    public void setBattery(String battery) { this.battery = battery; }
    public void setSpecialFeature(String specialFeature) { this.specialFeature = specialFeature; }

    @Override
    public String toString() {
        return "Phone Specifications:\n" +
                "Model: " + model + "\n" +
                "Processor: " + processor + "\n" +
                "Memory: " + memory + "\n" +
                "Camera: " + camera + "\n" +
                "Battery: " + battery + "\n" +
                "Special Feature: " + specialFeature;
    }
}

// Builder Interface
interface PhoneBuilder {
    PhoneBuilder setModel(String model);
    PhoneBuilder setProcessor(String processor);
    PhoneBuilder setMemory(String memory);
    PhoneBuilder setCamera(String camera);
    PhoneBuilder setBattery(String battery);
    PhoneBuilder setSpecialFeature(String specialFeature);
    Phone build();
}

// Concrete Builder
class SmartphoneBuilder implements PhoneBuilder {
    private Phone phone;

    public SmartphoneBuilder() {
        this.phone = new Phone();
    }

    @Override
    public PhoneBuilder setModel(String model) {
        phone.setModel(model);
        return this;
    }

    @Override
    public PhoneBuilder setProcessor(String processor) {
        phone.setProcessor(processor);
        return this;
    }

    @Override
    public PhoneBuilder setMemory(String memory) {
        phone.setMemory(memory);
        return this;
    }

    @Override
    public PhoneBuilder setCamera(String camera) {
        phone.setCamera(camera);
        return this;
    }

    @Override
    public PhoneBuilder setBattery(String battery) {
        phone.setBattery(battery);
        return this;
    }

    @Override
    public PhoneBuilder setSpecialFeature(String specialFeature) {
        phone.setSpecialFeature(specialFeature);
        return this;
    }

    @Override
    public Phone build() {
        return phone;
    }
}

// Director
class PhoneAssembler {
    public Phone assembleBusinessPhone(PhoneBuilder builder) {
        return builder.setModel("BusinessPro X1")
                .setProcessor("Snapdragon 8 Gen 2")
                .setMemory("12GB RAM, 256GB Storage")
                .setCamera("Triple 50MP Camera System")
                .setBattery("4500mAh")
                .setSpecialFeature("Secure Folder, DeX support")
                .build();
    }

    public Phone assembleCameraPhone(PhoneBuilder builder) {
        return builder.setModel("PhotoMaster P50")
                .setProcessor("Exynos 2200")
                .setMemory("8GB RAM, 128GB Storage")
                .setCamera("Quad 108MP Camera System with 100x Zoom")
                .setBattery("4800mAh")
                .setSpecialFeature("Pro Camera Mode, 8K Video Recording")
                .build();
    }

    public Phone assembleLongLastingPhone(PhoneBuilder builder) {
        return builder.setModel("PowerKing M20")
                .setProcessor("MediaTek Dimensity 9000")
                .setMemory("6GB RAM, 128GB Storage")
                .setCamera("Dual 48MP Camera System")
                .setBattery("7000mAh")
                .setSpecialFeature("Reverse Charging, Ultra Power Saving Mode")
                .build();
    }
}

// Demo class
public class BuilderDemo {
    public static void runDemo() {
        PhoneBuilder builder = new SmartphoneBuilder();
        PhoneAssembler assembler = new PhoneAssembler();

        System.out.println("Assembling a Business Class Phone:");
        Phone businessPhone = assembler.assembleBusinessPhone(builder);
        System.out.println(businessPhone);

        System.out.println("\nAssembling a Camera Phone:");
        Phone cameraPhone = assembler.assembleCameraPhone(builder);
        System.out.println(cameraPhone);

        System.out.println("\nAssembling a Long Lasting Phone:");
        Phone longLastingPhone = assembler.assembleLongLastingPhone(builder);
        System.out.println(longLastingPhone);

        System.out.println("\nAssembling a Custom Phone:");
        Phone customPhone = builder.setModel("CustomX")
                .setProcessor("Custom Chip")
                .setMemory("16GB RAM, 512GB Storage")
                .setCamera("Dual 64MP Camera System")
                .setBattery("5000mAh")
                .setSpecialFeature("Modular Design")
                .build();
        System.out.println(customPhone);
    }
}