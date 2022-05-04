package _case_study.services.implements_interface;

import _case_study.model.other_class.Booking;
import _case_study.services.interface_services.BookingService;
import _case_study.utils.BookingComparator;
import _case_study.utils.FormatString;
import _case_study.utils.ReadData;
import _case_study.utils.WriteData;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static final Scanner scn = new Scanner(System.in);
    private Set<Booking> dataBooking = new TreeSet<>(new BookingComparator());

    public BookingServiceImpl () {
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
        this.dataBooking = ReadData.readDataBooking();
        Booking newBooking = new Booking();
        String str;
        //Nhập ID Booking
        do {
            System.out.println("Định dạng BKID-xxxx (x: 0-9)");
            System.out.print("Nhập ID Booking: ");
            newBooking.setIdBooking(scn.nextLine());
        } while (! new FormatString().code(newBooking.getIdBooking())
                || ! isSameId(newBooking.getIdBooking()));
        newBooking.inputData();
        str = newBooking.getFacility().getIdService().substring(0, newBooking.getFacility().getIdService().indexOf("-"));
        if (str.equals("SVRO")) newBooking.setCreateContract(true);
        dataBooking.add(newBooking);
        WriteData.writeDataListBooking();
    }

    @Override
    public void displayList () {
        this.dataBooking = ReadData.readDataBooking();
        System.out.println("------Danh sách Booking------");
        for (Booking item : dataBooking) {
            if (! item.isCreateContract()) {
                System.out.println(item);
                System.out.println("-----------------------------");
            }
        }
    }

    public Booking getBooking (String idBooking) {
        this.dataBooking = ReadData.readDataBooking();
        assert dataBooking != null;
        for (Booking item : dataBooking) {
            if (item.getIdBooking().equals(idBooking))
                return item;
        }
        return null;
    }
}
