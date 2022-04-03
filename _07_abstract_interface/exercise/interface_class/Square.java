package _07_abstract_interface.exercise.interface_class;

public class Square implements Resizeable{
    private double edge;

    public Square(){
        this.edge = 1.0;
    }

    public Square(double edge){
        this.edge = edge;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    @Override
    public double getArea() {
        return this.edge * this.edge;
    }

    public void resize(double percent){
        System.out.println("Square area after change: " + (this.getArea() * (1.0 + percent)));
    }
}
