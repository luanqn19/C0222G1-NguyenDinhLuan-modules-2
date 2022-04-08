package _07_abstract_interface.exercise.interface_shape;

public class TestShape {
    public static void main(String[] args) {
        Square sqr = new Square(5.0);
        Rectangle rec = new Rectangle(5.0, 5.0);
        Circle cir = new Circle(5.0);

        Resizeable[] rez = {sqr, rec, cir};

        for (Resizeable resizeable : rez) {
            System.out.println("Area before change: " + resizeable.getArea());
            resizeable.resize(Math.floor((Math.random() * 99) + 10) / 100);
            System.out.println();
        }
    }
}
