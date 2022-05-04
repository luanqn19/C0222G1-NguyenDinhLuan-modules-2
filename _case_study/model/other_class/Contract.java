package _case_study.model.other_class;

import _case_study.utils.FormatString;

import java.util.Objects;
import java.util.Scanner;

public class Contract {
    private static final Scanner scn = new Scanner(System.in);
    private String numberOfContract; // Số hợp đồng
    private int deposit; // Tiền cọc trước
    private int totalPay; // Tổng thanh toán
    private boolean isSetVoucher;

    //Booking
    private Booking booking;

    public Contract () {
        this.booking = null;
        this.numberOfContract = "";
        this.deposit = 0;
        this.totalPay = 0;
    }

    public Contract (Booking booking , String numberOfContract ,
                     int deposit , int totalPay, boolean isSetVoucher) {
        this.booking = booking;
        this.numberOfContract = numberOfContract;
        this.deposit = deposit;
        this.totalPay = totalPay;
        this.isSetVoucher = isSetVoucher;
    }

    public void inputData (Booking booking) {
        boolean flag;
        //Lấy thông tin booking tạo contract
        this.setBooking(booking);

        //Nhập số tiền trả trước
        do {
            flag = true;
            try {
                System.out.print("Nhập số tiền trả trước (lớn hơn 0): ");
                this.setDeposit(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e) {
                flag = false;
            }
        } while (this.getDeposit() < 0 || ! flag);

        //Nhập tổng chi phí
        do {
            flag = true;
            try {
                System.out.print("Nhập tổng số chi phí (lớn hơn 0): ");
                this.setTotalPay(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e) {
                flag = false;
            }
        } while (this.getTotalPay() < 0 || ! flag);

        this.isSetVoucher = false;
    }

    public boolean isSetVoucher () {
        return isSetVoucher;
    }

    public void setSetVoucher (boolean setVoucher) {
        isSetVoucher = setVoucher;
    }

    public Booking getBooking () {
        return booking;
    }

    public void setBooking (Booking booking) {
        this.booking = booking;
    }

    public String getNumberOfContract () {
        return numberOfContract;
    }

    public void setNumberOfContract (String numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    public int getDeposit () {
        return deposit;
    }

    public void setDeposit (int deposit) {
        this.deposit = deposit;
    }

    public int getTotalPay () {
        return totalPay;
    }

    public void setTotalPay (int totalPay) {
        this.totalPay = totalPay;
    }

    @Override
    public String toString () {
        return "Thông tin Booking: " + "\n" + this.getBooking() + "\n" +
                "Số hợp đồng: " + this.getNumberOfContract() + "\n" +
                "Số tiền đưa trước: " + this.getDeposit() + "\n" +
                "Tổng số tiền thanh toán: " + this.totalPay;
    }

    @Override
    public boolean equals (Object o) {
        if (o == null) return false;
        else {
            Contract contract = (Contract) o;
            if (this.getNumberOfContract().equals(contract.getNumberOfContract())) return true;
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(getNumberOfContract() , getDeposit() , getTotalPay() , getBooking());
    }
}
