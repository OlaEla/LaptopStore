package NotebookStore;

import java.util.Objects;

public class Laptop {
    private String brand;
    private int ramSize;
    private int hddSize;
    private String os;
    private String color;
    private double screenSize;
    private double weight;

    // Конструктор
    public Laptop(String brand, int ramSize, int hddSize, String os, String color, double screenSize, double weight) {
        this.brand = brand;
        this.ramSize = ramSize;
        this.hddSize = hddSize;
        this.os = os;
        this.color = color;
        this.screenSize = screenSize;
        this.weight = weight;
    }

    // Переопределение метода toString() для вывода информации о ноутбуке
    @Override
    public String toString() {
        return "Brand: " + brand +
                ", RAM: " + ramSize + "GB" +
                ", HDD: " + hddSize + "GB" +
                ", OS: " + os +
                ", Color: " + color +
                ", Screen Size: " + screenSize +
                " inches, Weight: " + weight + " kg";
    }

    // Переопределение методов equals() и hashCode() для корректной работы с коллекциями
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ramSize == laptop.ramSize && hddSize == laptop.hddSize &&
                Double.compare(laptop.screenSize, screenSize) == 0 &&
                Double.compare(laptop.weight, weight) == 0 &&
                Objects.equals(brand, laptop.brand) &&
                Objects.equals(os, laptop.os) &&
                Objects.equals(color, laptop.color);
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(brand, ramSize, hddSize, os, color, screenSize, weight);
    }

    // Геттеры и сеттеры
    public int getRamSize() {
        return ramSize;
    }

    public int getHddSize() {
        return hddSize;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public double getWeight() {
        return weight;
    }
}