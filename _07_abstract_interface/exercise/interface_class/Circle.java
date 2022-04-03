package _07_abstract_interface.exercise.interface_class;

public class Circle implements Resizeable {
    private double radius;

    public Circle(){
        this.radius = 0.0d;
    }

    public Circle(double rad){
        this.radius = rad;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    public void resize(double percent){
        System.out.println("Circle area after change: " + (this.getArea() * (1.0 + percent)));
    }
}
