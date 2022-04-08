package _06_inheritance.exercise._point;

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
        super.setXY(x, y);
        this.z = z;
    }

    @Override
    public String toString(){
        String str = super.toString() +
                "Z: " + this.getZ() + "\n";
        return str;
    }
}
