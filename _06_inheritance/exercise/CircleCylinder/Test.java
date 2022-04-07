package _06_inheritance.exercise.CircleCylinder;

public class Test {
    public static void main(String[] args) {
        Circle cir = new Circle();
        cir.setRadius(5.0);
        cir.setColor("White");
        System.out.println("Circle: " + "\n" + cir);

        Cylinder cyl = new Cylinder();
        cyl.setRadius(6.0);
        cyl.setColor("blue");
        cyl.setHeight(3.0);
        System.out.println("Cylinder: " + "\n" + cyl);
    }
}
