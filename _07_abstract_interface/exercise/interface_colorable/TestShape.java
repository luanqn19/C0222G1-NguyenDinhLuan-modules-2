package _07_abstract_interface.exercise.interface_colorable;

import _07_abstract_interface.exercise.interface_colorable.Square;
import _07_abstract_interface.exercise.interface_colorable.Circle;
import _07_abstract_interface.exercise.interface_colorable.Colorable;
import _07_abstract_interface.exercise.interface_colorable.Rectangle;

import java.util.Arrays;

public class TestShape {
    public static void main (String[] args) {
        Rectangle rec = new Rectangle(5.0 , 5.0 , "blue");
        Square sqr = new Square(5.0 , "red");
        Circle cir = new Circle(5.0 , "green");

        Shape[] arr = {rec , sqr , cir};

        for (Shape testShape : arr) {
            String name = testShape.getClass().toString();
            String nameClass = name.substring(name.lastIndexOf(".") + 1);
            if (testShape instanceof Colorable) {
                System.out.print(nameClass + ": ");
                ((Colorable) testShape).howToColor();
            } else {
                System.out.println("Area " + nameClass + ": " + testShape.getArea());
            }
        }
    }
}
