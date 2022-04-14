package _11_stack_queue.exercise._organize_data;

public class Employee {
    private String name;
    private Boolean gender; // True: Nam, False: Nữ
    private String birthDay;

    public Employee () {
        this.name = "";
        this.gender = false;
        this.birthDay = "";
    }

    public Employee (String name , Boolean gender , String birthDay) {
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Boolean getGender () {
        return gender;
    }

    public void setGender (Boolean gender) {
        this.gender = gender;
    }

    public String getBirthDay () {
        return birthDay;
    }

    public void setBirthDay (String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString () {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
