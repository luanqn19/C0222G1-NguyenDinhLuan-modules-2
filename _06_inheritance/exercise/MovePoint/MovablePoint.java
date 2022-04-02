package _06_inheritance.exercise.MovePoint;

public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MovablePoint() {
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{this.getXSpeed(), this.getYSpeed()};
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return new String("x: " + this.getX() + "\n" +
                "y: " + this.getY() + "\n" +
                "Speed: " + this.getXSpeed() + " : " + this.getYSpeed());
    }

    public MovablePoint move(){
        this.x += this.xSpeed;
        this.y += this.ySpeed;
        return this;
    }

    public static void main(String[] args) {
        Point pnt = new Point(10,20);
        System.out.println("Pnt: " + "\n" + pnt.toString() + "\n");

        MovablePoint mvPnt = new MovablePoint(10, 20, 30, 40);
        System.out.println("mvPnt before: " + "\n" + mvPnt.toString() + "\n");

        mvPnt.move();

        System.out.println("mvPnt after move: " + "\n" + mvPnt.toString() + "\n");
    }
}
