package _05_access_modifier.exercise.Student;

public class Student {
    private String name;
    private String classes;

    public Student(){
        this.name = "John";
        this.classes = "C02";
    }

    public String getClasses() {
        return classes;
    }

    public String getName() {
        return name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setName(String name) {
        this.name = name;
    }
}
