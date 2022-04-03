package _07_abstract_interface.exercise.interface_class;

public class Rectangle implements Resizeable{
    private double width;
    private double height;

    public Rectangle(){
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
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

    @Override
    public double getArea(){
        return width * height;
    }

    public void resize(double percent){
        System.out.println("Rectangle area after change: " + (this.getArea() * (1.0 + percent)));
    }
}
