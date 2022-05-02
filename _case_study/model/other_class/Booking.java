package _case_study.model.other_class;

import _case_study.controller.FuramaController;
import _case_study.model.facility_class.Facility;
import _case_study.model.person_class.Customer;
import _case_study.services.implements_interface.CustomerServiceImpl;
import _case_study.services.implements_interface.FacilityServiceImpl;
import _case_study.utils.FormatString;

import java.util.Map;
import java.util.Scanner;

public class Booking {
    private static final Scanner scn = new Scanner(System.in);
    private String dateStart, dateEnd;
    private String idBooking;
    private boolean isCreateContrat; // Trạng thái đã tạo hợp đồng

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
        this.isCreateContrat = false;
    }

    public Booking (String dateStart , String dateEnd ,
                    String idBooking , Customer customer , Facility facility, boolean isCreateContrat) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.idBooking = idBooking;
        this.customer = customer;
        this.facility = facility;
        this.isCreateContrat = isCreateContrat;
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
        FuramaController.facilityService.displayList();
        String id;

        boolean flag;
        do {
            flag = true;
            System.out.println("Nhập ID Facility: ");
            id = scn.nextLine();
            for (Map.Entry<Facility, Integer> entry : FuramaController.facilityService.getDataFacility().entrySet()) {
                if (FuramaController.facilityService.getFacility(id) == null ||
                        (FuramaController.facilityService.getFacility(id) != null && entry.getValue() >= 5)) {
                    flag = false;
                }
            }

        } while (! flag);

        return FuramaController.facilityService.getFacility(id);
    }

    public void inputData () {
        //Chọn thông tin khách hàng
        this.setCustomer(chooseCustomer(FuramaController.customerService));

        //Chọn thông tin cơ sở vật chất
        this.setFacility(chooseFacility(FuramaController.facilityService));

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

    public boolean isCreateContrat () {
        return isCreateContrat;
    }

    public void setCreateContrat (boolean createContrat) {
        isCreateContrat = createContrat;
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
                "Ngày kết thúc: " + this.getDateEnd() + "\n" + "\n" +
                "Thông tin khách hàng: " + "\n" + this.getCustomer() + "\n" +
                "Thông tin cơ sở vật chất: " + "\n" + this.getFacility() + "\n";
    }
}
