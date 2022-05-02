package _case_study.model.other_class;

import _case_study.utils.BookingComparator;

import java.util.Scanner;

public class Promotion implements Comparable<Promotion>{
    private static final Scanner scn = new Scanner(System.in);
    private int yearOfUse;
    private String voucher;

    //Contract profile
    private Contract contract;

    public Promotion () {
        this.contract = null;
        this.yearOfUse = 0;
        this.voucher = "";
    }

    public Promotion (Contract contract , int yearOfUse , String voucher) {
        this.contract = contract;
        this.yearOfUse = yearOfUse;
        this.voucher = voucher;
    }

    public String getVoucher () {
        return voucher;
    }

    public void setVoucher (String voucher) {
        this.voucher = voucher;
    }

    public void inputData (Contract contract) {
        boolean flag;
        do {
            flag = true;
            try {
                this.setContract(contract);
                System.out.print("Nhập số năm sử dụng: ");
                this.setYearOfUse(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e) {
                flag = false;
            }
        } while (! flag || this.getYearOfUse() < 0);
    }

    public int getYearOfUse () {
        return yearOfUse;
    }

    public void setYearOfUse (int yearOfUse) {
        this.yearOfUse = yearOfUse;
    }

    public Contract getContract () {
        return contract;
    }

    public void setContract (Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString () {
        return "Năm sử dụng: " + this.getYearOfUse() + "\n" +
                "Voucher: " + this.getVoucher() + "\n" +
                "Contract info: \n" + this.getContract();
    }

    @Override
    public int compareTo (Promotion o) {
        Booking booking1 = this.getContract().getBooking();
        Booking booking2 = o.getContract().getBooking();
        return new BookingComparator().compare(booking1, booking2);
    }
}
