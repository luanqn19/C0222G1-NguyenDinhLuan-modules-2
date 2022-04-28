package _case_study.model.facility_class;

import _case_study.model.other_class.Booking;
import _case_study.utils.FormatString;

import java.util.Scanner;

public abstract class Facility {
    // Thêm boolean isMaintenance = false
    public static final Scanner scn = new Scanner(System.in);
    private static final String[] DATA_TYPE_OF_BORROW = {"Hour" , "Day" , "Month" , "Year"};
    protected double area;
    protected int price, maximumPerson;

    // typeOfBorrow : year, month, day, hour
    protected String idService, nameService, typeOfBorrow;

    public Facility () {
        this.idService = "";
        this.area = 0.0d;
        this.price = 0;
        this.maximumPerson = 0;
        this.nameService = "";
        this.typeOfBorrow = "";
    }

    public Facility (String idService , double area , int price ,
                     int maximumPerson , String nameService , String typeOfBorrow) {
        this.idService = idService;
        this.area = area;
        this.price = price;
        this.maximumPerson = maximumPerson;
        this.nameService = nameService;
        this.typeOfBorrow = typeOfBorrow;
    }

    public void inputData () {
        boolean flag;
        boolean flagChoose;
        int choose = 0;

        //Nhập tên dịch vụ
        do {
            System.out.println("Tên dịch vụ phải viết hoa ký tự đầu và ký tự sau là thường VD: Villa");
            System.out.println("Nhập tên dịch vụ dịch vụ: ");
            this.setNameService(scn.nextLine());
        }while (! new FormatString().nameService(this.getNameService()));

        //Nhập số lượng người
        do {
            flagChoose = true;
            try {
                System.out.println("Số lượng người phải lớn hơn 0 và nhỏ hơn 20");
                System.out.print("Nhập số lượng người tối đa: ");
                this.setMaximumPerson(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e) {
                flagChoose = false;
            }
        } while (this.getMaximumPerson() < 0 || this.getMaximumPerson() > 20 || ! flagChoose);

        //Nhập diện tích
        do {
            flagChoose = true;
            try {
                System.out.println("Diện tích phải lớn hơn 30m2");
                System.out.print("Nhập diện tích: ");
                this.setArea(Double.parseDouble(scn.nextLine()));
            } catch (NumberFormatException e) {
                flagChoose = false;
            }
        } while (this.getArea() < 0 || this.getArea() > 0 && this.getArea() < 30 || ! flagChoose);

        //Nhập kiểu thuê
        do {
            System.out.print("Nhập kiểu thuê (Hour, Day, Month, Year)");
            System.out.println("Nhập kiểu thuê dịch vụ: ");
            this.setTypeOfBorrow(scn.nextLine());
        }while (! new FormatString().borrowService(this.getTypeOfBorrow()));

        //Nhập giá
        do {
            flagChoose = true;
            try {
                System.out.println("Giá phải lớn hơn 0");
                System.out.print("Nhập giá: ");
                this.setPrice(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e){
                flagChoose = false;
            }
        } while (!flagChoose || this.getPrice() < 0);
    }

    public String getIdService () {
        return idService;
    }

    public void setIdService (String idService) {
        this.idService = idService;
    }

    public double getArea () {
        return area;
    }

    public void setArea (double area) {
        this.area = area;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }

    public int getMaximumPerson () {
        return maximumPerson;
    }

    public void setMaximumPerson (int maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public String getNameService () {
        return nameService;
    }

    public void setNameService (String nameService) {
        this.nameService = nameService;
    }

    public String getTypeOfBorrow () {
        return typeOfBorrow;
    }

    public void setTypeOfBorrow (String typeOfBorrow) {
        this.typeOfBorrow = typeOfBorrow;
    }

    @Override
    public String toString () {
        return "ID Dịch vụ: " + this.getIdService() + "\n" +
                "Diện tích: " + this.getArea() + "\n" +
                "Giá: " + this.getPrice() + "\n" +
                "Số người tối đa: " + this.getMaximumPerson() + "\n" +
                "Tên dịch vụ: " + this.getNameService() + "\n" +
                "Kiểu thuê: " + this.getTypeOfBorrow() + "\n";
    }


    @Override
    public int hashCode () {
        return super.hashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null) {
            return false;
        } else {
            Facility facility = (Facility) obj;
            if (this.getIdService().equals(facility.getIdService())) {
                return true;
            }
        }
        return false;
    }
}
