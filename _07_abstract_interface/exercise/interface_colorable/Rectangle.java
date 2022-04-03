package _07_abstract_interface.exercise.interface_colorable;

import _07_abstract_interface.exercise.interface_colorable.TestShape;
public class Rectangle extends TestShape{
    private double width;
    private double height;
    private String color;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        this.color = "black";
    }

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * height;
    }
}
