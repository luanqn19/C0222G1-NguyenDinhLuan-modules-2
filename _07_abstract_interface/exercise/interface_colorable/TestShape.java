package _07_abstract_interface.exercise.interface_colorable;

import _07_abstract_interface.exercise.interface_colorable.Square;
import _07_abstract_interface.exercise.interface_colorable.Circle;
import _07_abstract_interface.exercise.interface_colorable.Colorable;
import _07_abstract_interface.exercise.interface_colorable.Rectangle;

import java.util.Arrays;

public class TestShape {
    public void callFunction(Rectangle rec, Square sqr, Circle cir, String name){
        switch (name){
            case "Rectangle":
                System.out.println("Rectangle area: " + rec.getArea());
                break;
            case "Square":
                System.out.println("Square area: " + sqr.getArea());
                break;
            case "Circle":
                System.out.println("Circle area: " + cir.getArea());
                break;
        }
    }

    public static void main(String[] args) {
        Rectangle rec = new Rectangle(5.0, 5.0, "blue");
        Square sqr = new Square(5.0, "red");
        Circle cir = new Circle(5.0, "green");

        TestShape[] test = {rec, sqr, cir};

        for (TestShape testShape : test) {
            if (testShape instanceof Colorable) {
                ((Colorable) testShape).howToColor();
            } else {
                String name = testShape.getClass().toString();
                String nameClass = name.substring(name.lastIndexOf(".") + 1);
                testShape.callFunction(rec, sqr, cir, nameClass);
            }
        }
    }
}
