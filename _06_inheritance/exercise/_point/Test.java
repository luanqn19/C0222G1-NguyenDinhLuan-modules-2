package _06_inheritance.exercise._point;

public class Test {
    public static void main(String[] args) {
        Point2D pt2D = new Point2D(10,20);
        System.out.println("Point2D: " + "\n" + pt2D.toString());

        Point3D pt3D = new Point3D(30,50,60);
        System.out.println("Point3D: " + "\n" + pt3D.toString());
    }
}
