package _05_access_modifier.exercise;

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

    public static void main(String[] args) {
        Student stdent1 = new Student();
        System.out.println("stdent1 name: " + stdent1.getName());
        System.out.println("stdent1 class: " + stdent1.getClasses());

        Student stdent2 = new Student();
        stdent2.setName("David");
        stdent2.setClasses("C03");
        System.out.println("stdent2 name: " + stdent2.getName());
        System.out.println("stdent2 class: " + stdent2.getClasses());
    }
}
