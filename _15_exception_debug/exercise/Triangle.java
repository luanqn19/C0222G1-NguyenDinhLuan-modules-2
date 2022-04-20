package _15_exception_debug.exercise;

import java.util.Scanner;

public class Triangle {
    private double a, b, c;

    public Triangle (double a , double b , double c) throws IllegalTriangleException {
        if (a < 0 || b < 0 || c < 0)
            throw new IllegalTriangleException((a < 0 ? a : (b < 0 ? b : c)), " nhỏ hơn không");
        if (a > b + c)
            throw new IllegalTriangleException(a, b, c);
        else if (b > a + c)
            throw new IllegalTriangleException(b, a, c);
        else if (c > a + b)
            throw new IllegalTriangleException(c, a, b);
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public void setA (double a) {
        this.a = a;
    }

    public void setB (double b) {
        this.b = b;
    }

    public void setC (double c) {
        this.c = c;
    }

    public double getA () {
        return a;
    }

    public double getB () {
        return b;
    }

    public double getC () {
        return c;
    }

    @Override
    public String toString () {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
