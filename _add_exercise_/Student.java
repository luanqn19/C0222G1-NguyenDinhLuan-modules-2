package _add_exercise_;

import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private String address;
    private double point;
    public Student(){

    }

    public Student (String name , int age , String address , double point) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.point = point;
    }

    public void inputInfor(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        this.name = scn.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = Integer.parseInt(scn.nextLine());
        System.out.print("Nhập địa chỉ: ");
        this.address = scn.nextLine();
        System.out.print("Nhập điểm: ");
        this.point = Double.parseDouble(scn.nextLine());
    }

    public void displayInfor(){
        System.out.println("Họ và tên: " + this.getName());
        System.out.println("Tuổi: " + this.getAge());
        System.out.println("Địa chỉ: " + this.getAddress());
        System.out.println("Điểm: " + this.getPoint());
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public double getPoint () {
        return point;
    }

    public void setPoint (double point) {
        this.point = point;
    }
}
