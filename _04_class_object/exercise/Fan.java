package _04_class_object.exercise;

public class Fan {
    private int speed;
    private boolean status;
    private double radius;
    private String color;

    public Fan() {
        this.speed = 1;
        this.status = false;
        this.radius = 5;
        this.color = "blue";
    }

    @Override
    public String toString() {
        String str = "";
        if (getStatus()) {
            str = "Speed: " + (this.getSpeed() == 1 ? "SLOW" : (this.getSpeed() == 2 ? "MEDIUM" : "HIGH"))
                    + "\n" + "Color: " + this.getColor() + "\n" + "Radius: " + this.getRadius() + "\n" + "fan is on";
        } else {
            str = "Radius: " + this.getRadius() + "\n" + "Color: " + this.getColor() + "\n" + "fan is off";
        }
        return str;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int value) {
        this.speed = value;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean value) {
        this.status = value;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double value) {
        this.radius = value;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String value) {
        this.color = value;
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setStatus(true);
        System.out.println(fan1.toString());

        System.out.println();
        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setStatus(false);
        System.out.println(fan2.toString());
    }
}
