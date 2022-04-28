package _case_study.model.person_class;

import _case_study.utils.BirthOfDayException;
import _case_study.utils.FormatString;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Person {
    public static final Scanner scn = new Scanner(System.in);
    protected String name, address, birthDay, phone, email, gender;
    protected String document;

    public Person () {
        this.name = "";
        this.address = "";
        this.birthDay = "";
        this.phone = "";
        this.email = "";
        this.gender = "";
        this.document = "";
    }

    public Person (String name ,
                   String address ,
                   String birthDay ,
                   String phone ,
                   String email ,
                   String gender ,
                   String document) {
        this.name = name;
        this.address = address;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.document = document;
    }

    public boolean checkBirthDay (String str) {
        String[] birthDay = str.split("/");
        int dayOfBirth = Integer.parseInt(birthDay[0]);
        int monthOfBirth = Integer.parseInt(birthDay[1]);
        int yearOfBirth = Integer.parseInt(birthDay[2]);

        String currentDate = LocalDate.now().toString();
        String[] currentDayArray = currentDate.split("-");
        int currentDay = Integer.parseInt(currentDayArray[2]);
        int currentMonth = Integer.parseInt(currentDayArray[1]);
        int currentYear = Integer.parseInt(currentDayArray[0]);

        int age = 0;

        if (currentMonth > monthOfBirth) age = (currentYear - yearOfBirth) + 1;
        else if (currentMonth < monthOfBirth) age = currentYear - yearOfBirth;
        else {
            if (currentDay > dayOfBirth || currentDay == dayOfBirth) age = (currentYear - yearOfBirth) + 1;
            else age = currentYear - yearOfBirth;
        }

        if (age < 18 && age > 100) return false;
        return true;
    }

    public void inputData () {
        boolean flag;
        do {
            System.out.println("Định dạng tên VD:Nguyen Van An");
            System.out.print("Nhập tên nhân viên: ");
            this.setName(scn.nextLine());
        } while (! new FormatString().formatName(this.getName()));

        do {
            System.out.println("Định dạng địa chỉ VD: 347 Nguyen Hue, nếu kiệt 347/24 Nguyen Hue");
            System.out.print("Nhập địa chỉ: ");
            this.setAddress(scn.nextLine());
        } while (! new FormatString().formatAddress(this.getAddress()));

        //Thêm
        do {
            flag = true;
            try {
                System.out.println("Định dạng ngày dd/mm/yyyy");
                System.out.print("Nhập ngày sinh: ");
                this.setBirthDay(scn.nextLine());
                if (!checkBirthDay(this.getBirthDay())) throw new BirthOfDayException();
            } catch (BirthOfDayException e) {
                flag = false;
            }
        } while (! new FormatString().dateFormat(this.getBirthDay()) || ! flag);

        do {
            System.out.println("Định dạng số điện thoại VD: +840xxxxxxxxx (x: 0-9)");
            System.out.print("Nhập số điện thoại: ");
            this.setPhone(scn.nextLine());
        } while (! new FormatString().formatPhone(this.getPhone()));

        do {
            System.out.println("Định dạng email VD: tempmail123@domain.com");
            System.out.print("Nhập thư điện tử: ");
            this.setEmail(scn.nextLine());
        } while (! new FormatString().formatEmail(this.getEmail()));

        do {
            System.out.print("Nhập giới tính (Nữ/Nam): ");
            this.setGender(scn.nextLine());
        } while (! new FormatString().formatGender(this.getGender()));

        do {
            System.out.println("Định dạng CCCD/CMND xxxxxxxxx (x: 0-9)");
            System.out.print("Nhập CMND/CCCD: ");
            this.setDocument(scn.nextLine());
        } while (! new FormatString().formatDocument(this.getDocument()));
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getBirthDay () {
        return birthDay;
    }

    public void setBirthDay (String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String isGender () {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public String getGender () {
        return gender;
    }

    public String getDocument () {
        return document;
    }

    public void setDocument (String document) {
        this.document = document;
    }

    @Override
    public String toString () {
        return "Họ và tên: " + this.getName() + "\n" +
                "Địa chỉ: " + this.getAddress() + "\n" +
                "Ngày sinh: " + this.getBirthDay() + "\n" +
                "Số điện thoại: " + this.getPhone() + "\n" +
                "Địa chỉ email: " + this.getEmail() + "\n" +
                "Giới tính: " + this.getGender() + "\n" +
                "CMND/CCCD: " + this.getDocument() + "\n";
    }
}
