package _case_study.model.other_class;

import java.util.Scanner;

public class Promotion {
    private static final Scanner scn = new Scanner(System.in);
    private int yearOfUse;
    private Booking booking;
    private String voucher;

    public Promotion () {
        this.booking = null;
        this.yearOfUse = 0;
        this.voucher = "";
    }

    public Promotion (int yearOfUse , Booking booking) {
        this.yearOfUse = yearOfUse;
        this.booking = booking;
    }

    public String getVoucher () {
        return voucher;
    }

    public void setVoucher (String voucher) {
        this.voucher = voucher;
    }

    public void inputDate(Booking booking){
        boolean flag;
        do {
            flag = true;
            try {
                this.setBooking(booking);
                System.out.print("Nhập số năm sử dụng: ");
                this.setYearOfUse(Integer.parseInt(scn.nextLine()));
            }catch (NumberFormatException e){
                System.err.println("Dữ liệu không hợp lệ");
                flag = false;
            }
        }while (!flag || this.getYearOfUse() < 0);
    }

    public int getYearOfUse () {
        return yearOfUse;
    }

    public void setYearOfUse (int yearOfUse) {
        this.yearOfUse = yearOfUse;
    }

    public Booking getBooking () {
        return booking;
    }

    public void setBooking (Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString () {
        return "Năm sử dụng: " + this.getYearOfUse() + "\n" +
                "Booking: \n" + this.getBooking();
    }
}
