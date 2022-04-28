package _case_study.model.other_class;

import _case_study.model.facility_class.Facility;
import _case_study.model.person_class.Customer;
import _case_study.services.implements_interface.CustomerServiceImpl;
import _case_study.services.implements_interface.FacilityServiceImpl;
import _case_study.utils.FormatString;

import java.util.Scanner;

public class Booking {
    private static final Scanner scn = new Scanner(System.in);
    private String dateStart, dateEnd;
    private String idBooking;

    //Customer
    private Customer customer;

    //Facility
    private Facility facility;

    public Booking () {
        this.dateStart = "";
        this.dateEnd = "";
        this.idBooking = "";
        this.customer = null;
        this.facility = null;
    }

    public Booking (String dateStart , String dateEnd ,
                    String idBooking , Customer customer , Facility facility) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.idBooking = idBooking;
        this.customer = customer;
        this.facility = facility;
    }

    public void inputData (CustomerServiceImpl customerService ,
                           FacilityServiceImpl facilityService) {
        //Chọn thông tin khách hàng
        this.setCustomer(chooseCustomer(customerService));

        //Chọn thông tin cơ sở vật chất
        this.setFacility(chooseFacility(facilityService));

        //Nhập ngày Booking
        do {
            System.out.println("Định dạng ngày dd/mm/yyyy");
            System.out.print("Nhập ngày booking: ");
            this.setDateStart(scn.nextLine());
        } while (! new FormatString().dateFormat(this.getDateStart()));

        //Nhập ngày trả
        do {
            System.out.println("Định dạng ngày dd/mm/yyyy");
            System.out.print("Nhập ngày trả: ");
            this.setDateEnd(scn.nextLine());
        } while (! new FormatString().dateFormat(this.getDateEnd()));
    }

    public Customer chooseCustomer (CustomerServiceImpl customerService) {
        // Hiển thị danh sách khách hàng
        customerService.displayList();
        String id;

        do {
            System.out.println("Nhập ID Customer: ");
            id = scn.nextLine();
        } while (customerService.getCustomer(id) == null);

        return customerService.getCustomer(id);
    }

    public Facility chooseFacility (FacilityServiceImpl facilityService) {
        // Hiển thị danh sách cơ sở vậy chất
        facilityService.displayList();
        String id;

        do {
            System.out.println("Nhập ID Facility: ");
            id = scn.nextLine();
        } while (facilityService.getFacility(id) == null);

        return facilityService.getFacility(id);
    }

    public String getDateStart () {
        return dateStart;
    }

    public void setDateStart (String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd () {
        return dateEnd;
    }

    public void setDateEnd (String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getIdBooking () {
        return idBooking;
    }

    public void setIdBooking (String idBooking) {
        this.idBooking = idBooking;
    }


    public Customer getCustomer () {
        return customer;
    }

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility () {
        return facility;
    }

    public void setFacility (Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString () {
        return "ID Booking: " + this.getIdBooking() + "\n" +
                "Ngày bắt đầu: " + this.getDateStart() + "\n" +
                "Ngày kết thúc: " + this.getDateEnd() + "\n";
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
            Booking booking = (Booking) obj;
            if (this.idBooking.equals(booking.getIdBooking())) {
                return true;
            }
        }
        return false;
    }
}
