package _06_inheritance.exercise.PointExercise;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ(){
        return new float[]{this.getX(), this.getY(), this.getZ()};
    }

    public void setXYZ(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString(){
        String str = "X: " + this.getX() + "\n" +
                "Y: " + this.getY() + "\n" +
                "Z: " + this.getZ() + "\n";
        return str;
    }

    public static void main(String[] args) {
        Point2D pt2D = new Point2D(10,20);
        System.out.println("Point2D: " + "\n" + pt2D.toString());

        Point3D pt3D = new Point3D(10,20,30);
        System.out.println("Point3D: " + "\n" + pt3D.toString());
    }
}
