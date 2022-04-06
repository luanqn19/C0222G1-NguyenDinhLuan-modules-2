package _04_class_object.exercise;

public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;
    private int speed;
    private boolean status;
    private double radius;
    private String color;

    public Fan () {
        this.speed = this.SLOW;
        this.status = false;
        this.radius = 5;
        this.color = "blue";
    }

    @Override
    public String toString () {
        String str = "";
        if (getStatus()) {
            str = "Speed: " + this.getSpeed() + "\n" + "Color: " + this.getColor() + "\n" +
                    "Radius: " + this.getRadius() + "\n" + "fan is on";
        } else {
            str = "Radius: " + this.getRadius() + "\n" + "Color: " + this.getColor() + "\n" + "fan is off";
        }
        return str;
    }

    public int getSpeed () {
        return this.speed;
    }

    public void setSpeed (int value) {
        this.speed = value;
    }

    public boolean getStatus () {
        return this.status;
    }

    public void setStatus (boolean value) {
        this.status = value;
    }

    public double getRadius () {
        return this.radius;
    }

    public void setRadius (double value) {
        this.radius = value;
    }

    public String getColor () {
        return this.color;
    }

    public void setColor (String value) {
        this.color = value;
    }

}
