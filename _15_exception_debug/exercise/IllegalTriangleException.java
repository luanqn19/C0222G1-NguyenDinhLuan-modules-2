package _15_exception_debug.exercise;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException (double a, String message) {
        super(a + message);
    }

    public IllegalTriangleException (double a, double b, double c) {
        super("Cạnh " + a + " lớn hơn tổng 2 cạnh " + b + " và " + c);
    }
}
