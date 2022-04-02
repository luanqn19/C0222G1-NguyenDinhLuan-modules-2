package _06_inheritance.exercise.CircleCylinder;

public class Circle {
    protected double radius;
    protected String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        String str = "Radius: " + this.getRadius() + "\n" +
                "Color: " + this.getColor() + "\n" +
                "Area: " + this.getArea() + "\n";
        return str;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
