package _06_inheritance.exercise.CircleCylinder;

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
        String str = "Radius: " + this.getRadius() + "\n" +
                "Color: " + this.getColor() + "\n" +
                "Area: " + this.getArea() + "\n" +
                "Volume: " + getVolume() + "\n";
        return str;
    }

    public static void main(String[] args) {
        Circle cir = new Circle();
        cir.setRadius(5.0);
        cir.setColor("White");
        System.out.println("Circle: " + "\n" + cir.toString());

        Cylinder cyl = new Cylinder();
        cyl.setRadius(6.0);
        cyl.setColor("blue");
        cyl.setHeight(3.0);
        System.out.println("Cylinder: " + "\n" + cyl.toString());
    }
}
