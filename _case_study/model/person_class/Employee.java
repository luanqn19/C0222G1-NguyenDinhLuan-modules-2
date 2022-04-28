package _case_study.model.person_class;

import _case_study.utils.FormatString;

public class Employee extends Person {
    private static final String[] DATA_ACADEMIC_LEVEL = {"Intermediate", "Colleges", "University", "After University"};
    private static final String[] DATA_POSITION = {"Receptionist", "Serve", "Expert", "Supervisor", "Manager", "President"};
    private String idEmployee;
    private double salary;
    //Intermediate: Trung cấp, Colleges: Cao đẳng, University: Đại học, After University: Sau đại học
    private String academicLevel;
    //Receptionist: Lễ tân, Serve: Phục vụ, Expert: chuyên viên, Supervisor: giám sát, Manager: quản lý, President: giám đốc
    private String position;

    public Employee () {
        super();
        this.idEmployee = "";
        this.salary = Double.MIN_VALUE;
        this.academicLevel = "";
        this.position = "";
    }

    public Employee (String name , String address ,
                     String birthDay , String phone ,
                     String email , String gender ,
                     String document , String idEmployee ,
                     double salary , String academicLevel , String position) {
        super(name , address , birthDay , phone , email , gender , document);
        this.idEmployee = idEmployee;
        this.salary = salary;
        this.academicLevel = academicLevel;
        this.position = position;
    }

    public void inputData(){
        super.inputData();
        boolean flag;
        int choose = 0;

        do {
            flag = true;
            try {
                System.out.print("Nhập mức lương: ");
                this.setSalary(Double.parseDouble(scn.nextLine()));
            } catch (NumberFormatException e){
                flag = false;
            }
        }while (!flag || this.getSalary() < 0);

        System.out.println("Lựa chọn trình độ học vấn: ");
        System.out.println("\t1.Trung cấp. ");
        System.out.println("\t2.Cao đẳng. ");
        System.out.println("\t3.Đại học. ");
        System.out.println("\t4.Sau đại học. ");

        do {
            flag = true;
            try {
                System.out.print("Your choose: ");
                choose = Integer.parseInt(scn.nextLine());
                if (choose < 0 && choose > 4) flag = false;
            } catch (NumberFormatException e){
                flag = false;
            }
        } while (!flag);

        switch (scn.nextLine()){
            case "1":
                this.setAcademicLevel(DATA_ACADEMIC_LEVEL[0]);
                break;
            case "2":
                this.setAcademicLevel(DATA_ACADEMIC_LEVEL[1]);
                break;
            case "3":
                this.setAcademicLevel(DATA_ACADEMIC_LEVEL[2]);
                break;
            case "4":
                this.setAcademicLevel(DATA_ACADEMIC_LEVEL[3]);
                break;
        }

        System.out.println("Lựa chọn vị trí: ");
        System.out.println("\t1.Lễ tân. ");
        System.out.println("\t2.Phục vụ. ");
        System.out.println("\t3.Chuyên viên. ");
        System.out.println("\t4.Giám sát. ");
        System.out.println("\t5.Quản lý. ");
        System.out.println("\t6.Giám đốc. ");

        do {
            flag = true;
            try {
                System.out.print("Your choose: ");
                choose = Integer.parseInt(scn.nextLine());
                if (choose < 0 && choose > 6) flag = false;
            } catch (NumberFormatException e){
                flag = false;
            }
        } while (!flag);

        switch (choose){
            case 1:
                this.setPosition(DATA_POSITION[0]);
                break;
            case 2:
                this.setPosition(DATA_POSITION[1]);
                break;
            case 3:
                this.setPosition(DATA_POSITION[2]);
                break;
            case 4:
                this.setPosition(DATA_POSITION[3]);
                break;
            case 5:
                this.setPosition(DATA_POSITION[4]);
                break;
            case 6:
                this.setPosition(DATA_POSITION[5]);
                break;
        }
    }

    public String getIdEmployee () {
        return idEmployee;
    }

    public void setIdEmployee (String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public double getSalary () {
        return salary;
    }

    public void setSalary (double salary) {
        this.salary = salary;
    }

    public String getAcademicLevel () {
        return academicLevel;
    }

    public void setAcademicLevel (String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition () {
        return position;
    }

    public void setPosition (String position) {
        this.position = position;
    }

    @Override
    public String toString () {
        return super.toString() +
                "ID nhân viên: " + this.getIdEmployee() + "\n" +
                "Mức lương: " + this.getSalary() + "\n" +
                "Trình độ học vấn: " + this.getAcademicLevel() + "\n" +
                "Vị trí: " + this.getPosition() + "\n";
    }
}
