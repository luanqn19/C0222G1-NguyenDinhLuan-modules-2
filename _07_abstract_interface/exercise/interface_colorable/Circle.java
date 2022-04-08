package _07_abstract_interface.exercise.interface_colorable;

import _07_abstract_interface.exercise.interface_colorable.TestShape;
public class Circle extends Shape{
    private double radius;
    private String color;

    public Circle(){
        this.radius = 0.0d;
        this.color = "black";
    }

    public Circle(double rad, String color){
        this.radius = rad;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }
}
