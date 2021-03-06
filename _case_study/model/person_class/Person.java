package _case_study.model.person_class;

import _case_study.utils.BirthOfDayException;
import _case_study.utils.FormatString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("?????nh d???ng t??n VD:Nguyen Van An");
            System.out.print("Nh???p t??n nh??n vi??n: ");
            this.setName(scn.nextLine());
        } while (! new FormatString().formatName(this.getName()));

        do {
            System.out.println("?????nh d???ng ?????a ch??? VD: 347 Nguyen Hue, n???u ki???t 347/24 Nguyen Hue");
            System.out.print("Nh???p ?????a ch???: ");
            this.setAddress(scn.nextLine());
        } while (! new FormatString().formatAddress(this.getAddress()));

        //Th??m
        do {
            flag = true;
            try {
                System.out.println("?????nh d???ng ng??y dd/mm/yyyy");
                System.out.print("Nh???p ng??y sinh: ");
                this.setBirthDay(scn.nextLine());
                if (!checkBirthDay(this.getBirthDay())) throw new BirthOfDayException();
            } catch (BirthOfDayException e) {
                flag = false;
            }
        } while (! new FormatString().dateFormat(this.getBirthDay()) || ! flag);

        do {
            System.out.println("?????nh d???ng s??? ??i???n tho???i VD: +840xxxxxxxxx (x: 0-9)");
            System.out.print("Nh???p s??? ??i???n tho???i: ");
            this.setPhone(scn.nextLine());
        } while (! new FormatString().formatPhone(this.getPhone()));

        do {
            System.out.println("?????nh d???ng email VD: tempmail123@domain.com");
            System.out.print("Nh???p th?? ??i???n t???: ");
            this.setEmail(scn.nextLine());
        } while (! new FormatString().formatEmail(this.getEmail()));

        do {
            System.out.print("Nh???p gi???i t??nh (N???/Nam): ");
            this.setGender(scn.nextLine());
        } while (! new FormatString().formatGender(this.getGender()));

        do {
            System.out.println("?????nh d???ng CCCD/CMND xxxxxxxxx (x: 0-9)");
            System.out.print("Nh???p CMND/CCCD: ");
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
        return "H??? v?? t??n: " + this.getName() + "\n" +
                "?????a ch???: " + this.getAddress() + "\n" +
                "Ng??y sinh: " + this.getBirthDay() + "\n" +
                "S??? ??i???n tho???i: " + this.getPhone() + "\n" +
                "?????a ch??? email: " + this.getEmail() + "\n" +
                "Gi???i t??nh: " + this.getGender() + "\n" +
                "CMND/CCCD: " + this.getDocument() + "\n";
    }
}
