package _06_inheritance.exercise._point;

public class Point2D {
    protected float x;
    protected float y;

    public Point2D(){
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        float[] temp = {this.x, this.y};
        return temp;
    }

    @Override
    public String toString(){
        String str = "X: " + this.getX() + "\n" +
                "Y: " + this.getY() + "\n";
        return str;
    }
}
