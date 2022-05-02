package _case_study.services.implements_interface;

import _case_study.model.person_class.Employee;
import _case_study.services.interface_services.EmployeeService;
import _case_study.utils.FormatString;
import _case_study.utils.ReadData;
import _case_study.utils.WriteData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    public static final Scanner scn = new Scanner(System.in);
    private List<Employee> dataEmployee = new ArrayList<>();

    public EmployeeServiceImpl () {
        //Đọc dữ liệu trong employee.csv
        this.dataEmployee = ReadData.readDataEmployee();
    }

    public boolean isSameId (String id) {
        for (Employee item : dataEmployee) {
            if (item.getIdEmployee().equals(id)) return false;
        }
        return true;
    }

    public void addNew () {
        //Đọc dữ liệu trong employee.csv
        this.dataEmployee = ReadData.readDataEmployee();
        Employee employee = new Employee();

        do {
            System.out.println("Định dạng ID EMID-xxxx (x: 0-9)");
            System.out.print("Nhập ID nhân viên: ");
            employee.setIdEmployee(scn.nextLine());
        } while (! new FormatString().code(employee.getIdEmployee())
                || ! isSameId(employee.getIdEmployee()));

        employee.inputData();
        dataEmployee.add(employee);
        //Ghi dữ liệu ra file employee.csv
        WriteData.writeDataListEmployee();
    }

    public void displayList () {
        //Đọc dữ liệu trong employee.csv
        this.dataEmployee = ReadData.readDataEmployee();
        System.out.println("------Danh sách nhân viên------");
        for (Employee item : dataEmployee) {
            System.out.println(item);
            System.out.println("-----------------------------");
        }
    }

    public void editInfor () {
        //Đọc dữ liệu trong employee.csv
        this.dataEmployee = ReadData.readDataEmployee();
        boolean flag = true;
        System.out.print("Nhập id cần edit: ");
        String id = scn.nextLine();
        for (Employee item : dataEmployee) {
            if (item.getIdEmployee().equals(id)) {
                flag = false;
                System.out.println("Nhập thông tin nhân viên: ");
                item.inputData();
                //Ghi dữ liệu ra file employee.csv
                WriteData.writeDataListEmployee();
            }
        }
        if (flag) System.out.println("ID Không tìm thấy!");
    }

    public List<Employee> getDataListEmployee () {
        return dataEmployee;
    }

    public void setDataListEmployee (List<Employee> listData) {
        this.dataEmployee = listData;
    }
}
