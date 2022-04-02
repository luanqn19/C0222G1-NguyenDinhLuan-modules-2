package _05_access_modifier.exercise;

public class Circle {
    private double radius;
    private String color;

    public Circle(){
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double rad){
        this.radius = rad;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    public static void main(String[] args) {
        Circle testCircle1 = new Circle();
        System.out.println("testCircle1 Area: " + testCircle1.getArea());

        Circle testCircle2 = new Circle();
        testCircle2.setRadius(5.0);
        System.out.println("testCircle2 Area: " + testCircle2.getArea());
    }
}
