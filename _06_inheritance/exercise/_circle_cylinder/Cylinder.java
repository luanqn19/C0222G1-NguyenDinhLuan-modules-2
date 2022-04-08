package _06_inheritance.exercise._circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){
        this.radius = 1.0;
        this.height = 1.0;
        this.color = "black";
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return this.getArea() * this.getHeight();
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    public String toString(){
        String str = super.toString() +
                "Volume: " + getVolume() + "\n";
        return str;
    }
}
