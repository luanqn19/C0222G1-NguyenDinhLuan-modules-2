package _05_access_modifier.exercise.Circle;

public class CircleTest {
    public static void main(String[] args) {
        Circle testCircle1 = new Circle();
        System.out.println("testCircle1 Area: " + testCircle1.getArea());

        Circle testCircle2 = new Circle();
        testCircle2.setRadius(5.0);
        System.out.println("testCircle2 Area: " + testCircle2.getArea());
    }
}
