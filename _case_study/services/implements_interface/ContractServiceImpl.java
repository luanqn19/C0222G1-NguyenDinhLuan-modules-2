package _case_study.services.implements_interface;

import _case_study.model.other_class.Booking;
import _case_study.model.other_class.Contract;
import _case_study.model.person_class.Customer;
import _case_study.services.interface_services.ContactService;
import _case_study.utils.FormatString;

import java.util.*;

public class ContractServiceImpl implements ContactService {
    private static final Scanner scn = new Scanner(System.in);
    private List<Contract> dataContract = new ArrayList<>();
    private Set<Booking> dataBooking = new BookingServiceImpl().getDataListBooking();

    public boolean isSameId (String numberContract) {
        for (Contract item : dataContract) {
            if (item.getNumberOfContract().equals(numberContract)) return false;
        }
        return true;
    }

    @Override
    public void addNew () {
        Queue<Booking> bookingQueue = new LinkedList<>();
        for (Booking item : dataBooking) {
            bookingQueue.add(item);
        }

        while (! bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();
            System.out.println("Đang tạo hợp đồng booking infor: " + booking);
            System.out.println("Đang tạo hợp đồng khác hàng: " + customer);

            Contract contract = new Contract();
            //Nhập mã hợp đồng
            do {
                System.out.println("ID định dạng CID-xxxx (x: 0-9)");
                System.out.print("Nhập ID hợp đồng: ");
                contract.setNumberOfContract(scn.nextLine());
            } while (! new FormatString().code(contract.getNumberOfContract())
                    || ! isSameId(contract.getNumberOfContract()));
            contract.inputData(booking);

            dataContract.add(contract);
            System.out.println("Success");
        }
    }

    @Override
    public void displayList () {
        System.out.println("------Danh sách Contract------");
        for (Contract item : dataContract) {
            System.out.println(item);
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void editContract () {
        boolean flag;

        System.out.println("Nhập ID hợp đồng: ");
        String numberContract = scn.nextLine();

        for (Contract item : dataContract) {
            if (item.getNumberOfContract().equals(numberContract)) {
                //Nhập mã hợp đồng
                do {
                    System.out.println("ID định dạng CID-xxxx (x: 0-9)");
                    System.out.print("Nhập ID hợp đồng: ");
                    item.setNumberOfContract(scn.nextLine());
                } while (! new FormatString().code(item.getNumberOfContract()));

                //Nhập số tiền trả trước
                do {
                    flag = true;
                    try {
                        System.out.print("Nhập số tiền trả trước (lớn hơn 0)");
                        item.setDeposit(Integer.parseInt(scn.nextLine()));
                    } catch (NumberFormatException e) {
                        flag = false;
                    }
                } while (item.getDeposit() < 0 || ! flag);

                //Nhập tổng chi phí
                do {
                    flag = true;
                    try {
                        System.out.print("Nhập tổng số chi phí (lớn hơn 0)");
                        item.setTotalPay(Integer.parseInt(scn.nextLine()));
                    } catch (NumberFormatException e) {
                        flag = false;
                    }
                } while (item.getTotalPay() < 0 || ! flag);
            }
        }
    }

    public List<Contract> getDataListContract () {
        return dataContract;
    }

    public void setDataListContract (List<Contract> listData) {
        this.dataContract = listData;
    }
}
