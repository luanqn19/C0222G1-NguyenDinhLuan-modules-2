package _case_study.services.implements_interface;

import _case_study.model.person_class.Customer;
import _case_study.services.interface_services.CustomerService;
import _case_study.utils.FormatString;
import _case_study.utils.ReadData;
import _case_study.utils.WriteData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static final Scanner scn = new Scanner(System.in);
    private List<Customer> dataCustomer = new LinkedList<>();

    public CustomerServiceImpl () {
    }

    public boolean isSameId (String id) {
        for (Customer item : dataCustomer) {
            if (item.getIdCustomer().equals(id)) return false;
        }
        return true;
    }

    public void addNew () {
        //Đọc dữ liệu trong file customer.csv
        this.dataCustomer = ReadData.readDataCustomer();
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
        //Ghi dữ liệu ra file customer.csv
        WriteData.writeDataListCustomer();
    }

    public void displayList () {
        //Đọc dữ liệu trong file customer.csv
        this.dataCustomer = ReadData.readDataCustomer();
        System.out.println("------Danh sách khách hàng------");
        for (Customer item : dataCustomer) {
            System.out.println(item);
            System.out.println("-----------------------------");
        }
    }

    public void editInfor () {
        //Đọc dữ liệu trong file customer.csv
        this.dataCustomer = ReadData.readDataCustomer();
        boolean flag = true;
        System.out.print("Nhập id cần edit: ");
        String id = scn.nextLine();
        for (Customer item : dataCustomer) {
            if (item.getIdCustomer().equals(id)) {
                flag = false;
                System.out.println("Nhập thông tin nhân viên: ");
                item.inputData();
                //Ghi dữ liệu ra file customer.csv
                WriteData.writeDataListCustomer();
            }
        }
        if (flag) System.out.println("ID Không tìm thấy!");
    }

    public Customer getCustomer (String idCustomer) {
        this.dataCustomer = ReadData.readDataCustomer();
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
