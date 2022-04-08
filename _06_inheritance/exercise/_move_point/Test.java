package _06_inheritance.exercise._move_point;

public class Test {
    public static void main(String[] args) {
        Point pnt = new Point(10,20);
        System.out.println("Pnt: " + "\n" + pnt + "\n");

        MovablePoint mvPnt = new MovablePoint(10, 20, 30, 40);
        System.out.println("mvPnt before: " + "\n" + mvPnt + "\n");

        mvPnt.move();

        System.out.println("mvPnt after move: " + "\n" + mvPnt + "\n");
    }
}
