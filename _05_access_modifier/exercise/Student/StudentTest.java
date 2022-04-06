package _05_access_modifier.exercise.Student;

public class StudentTest {
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
