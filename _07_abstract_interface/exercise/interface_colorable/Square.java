package _07_abstract_interface.exercise.interface_colorable;

import _07_abstract_interface.exercise.interface_colorable.Colorable;
import _07_abstract_interface.exercise.interface_colorable.TestShape;
public class Square extends TestShape implements Colorable {
    private double edge;
    private String color;

    public Square(){
        this.edge = 1.0;
        this.color = "black";
    }

    public Square(double edge, String color){
        this.edge = edge;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public double getArea() {
        return this.edge * this.edge;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides " + this.getColor());
    }
}
