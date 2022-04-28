package _case_study.services.implements_interface;

import _case_study.model.facility_class.Facility;
import _case_study.model.other_class.Booking;
import _case_study.model.other_class.Contract;
import _case_study.services.interface_services.BookingService;
import _case_study.services.interface_services.ContactService;
import _case_study.utils.BookingComparator;
import _case_study.utils.FormatString;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static final Scanner scn = new Scanner(System.in);
    private CustomerServiceImpl listCustomer = new CustomerServiceImpl();
    private FacilityServiceImpl listFacility = new FacilityServiceImpl();
    private Set<Booking> dataBooking = new TreeSet<>(new BookingComparator());

    public BookingServiceImpl () {
    }

    public BookingServiceImpl (CustomerServiceImpl listCustomer ,
                               FacilityServiceImpl listFacility) {
        this.listCustomer = listCustomer;
        this.listFacility = listFacility;
    }

    public boolean isSameId (String id) {
        for (Booking item : dataBooking) {
            if (item.getIdBooking().equals(id)) return false;
        }
        return true;
    }

    public Set<Booking> getDataListBooking () {
        return dataBooking;
    }

    public void setDataListBooking (Set<Booking> listData) {
        this.dataBooking = listData;
    }

    @Override
    public void addNew () {
        Booking newBooking = new Booking();
        //Nhập ID Booking
        do {
            System.out.println("Định dạng BKID-xxxx (x: 0-9)");
            System.out.print("Nhập ID Booking: ");
            newBooking.setIdBooking(scn.nextLine());
        } while (! new FormatString().code(newBooking.getIdBooking())
                || ! isSameId(newBooking.getIdBooking()));
        newBooking.inputData(listCustomer , listFacility);
        dataBooking.add(newBooking);
    }

    @Override
    public void displayList () {
        System.out.println("------Danh sách Booking------");
        for (Booking item : dataBooking) {
            System.out.println(item);
            System.out.println("-----------------------------");
        }
    }
}
