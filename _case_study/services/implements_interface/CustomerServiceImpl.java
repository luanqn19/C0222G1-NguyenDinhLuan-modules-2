package _case_study.services.implements_interface;

import _case_study.model.other_class.Booking;
import _case_study.model.person_class.Customer;
import _case_study.model.person_class.Employee;
import _case_study.services.interface_services.CustomerService;
import _case_study.utils.FormatString;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static final Scanner scn = new Scanner(System.in);
    private List<Customer> dataCustomer = new LinkedList<>();

    public boolean isSameId (String id) {
        for (Customer item : dataCustomer) {
            if (item.getIdCustomer().equals(id)) return false;
        }
        return true;
    }

    public void addNew () {
        Customer customer = new Customer();
        //Nhập ID Customer
        do {
            System.out.println("Định dạng ID CMID-xxxx (x: 0-9)");
            System.out.print("Nhập ID khách hàng: ");
            customer.setIdCustomer(scn.nextLine());
        } while (! new FormatString().code(customer.getIdCustomer())
                || ! isSameId(customer.getIdCustomer()));
        customer.inputData();
        dataCustomer.add(customer);
    }

    public void displayList () {
        System.out.println("------Danh sách khách hàng------");
        for (Customer item : dataCustomer) {
            System.out.println(item);
            System.out.println("-----------------------------");
        }
    }

    public void editInfor () {
        boolean flag = true;
        System.out.print("Nhập id cần edit: ");
        String id = scn.nextLine();
        for (Customer item : dataCustomer) {
            if (item.getIdCustomer().equals(id)) {
                flag = false;
                System.out.println("Nhập thông tin nhân viên: ");
                item.inputData();
            }
        }
        if (flag) System.out.println("ID Không tìm thấy!");
    }

    public Customer getCustomer (String idCustomer) {
        for (Customer item : dataCustomer) {
            if (item.getIdCustomer().equals(idCustomer))
                return item;
        }
        return null;
    }

    public List<Customer> getDataListCustomer () {
        return dataCustomer;
    }

    public void setDataListCustomer (List<Customer> listData) {
        this.dataCustomer = listData;
    }
}
