package _case_study.utils;

import _case_study.model.facility_class.Facility;
import _case_study.model.facility_class.House;
import _case_study.model.facility_class.Room;
import _case_study.model.facility_class.Villa;
import _case_study.model.other_class.Booking;
import _case_study.model.other_class.Contract;
import _case_study.model.other_class.Promotion;
import _case_study.model.person_class.Customer;
import _case_study.model.person_class.Employee;
import _case_study.services.implements_interface.*;

import java.io.*;
import java.util.Map;

public class WriteData {
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    private FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private BookingServiceImpl bookingService = new BookingServiceImpl(customerService , facilityService);
    private ContractServiceImpl contractService = new ContractServiceImpl();
    private PromotionServiceImpl promotionService = new PromotionServiceImpl();

    public WriteData (EmployeeServiceImpl employeeService ,
                      CustomerServiceImpl customerService ,
                      FacilityServiceImpl facilityService ,
                      BookingServiceImpl bookingService ,
                      ContractServiceImpl contractService ,
                      PromotionServiceImpl promotionService) {
        this.employeeService = employeeService;
        this.customerService = customerService;
        this.facilityService = facilityService;
        this.bookingService = bookingService;
        this.contractService = contractService;
        this.promotionService = promotionService;
    }

    public void writeAllData () {
        writeDataListEmployee();
        writeDataListCustomer();
        writeDataListFacility(facilityService.getDataFacility(), "facility.csv");
        writeDataListFacility(facilityService.getDataFacilityMaintenance(), "facility_maintenance.csv");
        writeDataListBooking();
        writeDataListContract();
        writeDataListPromotion();
    }

    public void writeDataListEmployee () {
        try {
            File file = new File("src\\_case_study\\data\\employee.csv");
            if (! file.exists()) throw new FileNotFoundException("File not found");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Employee item : employeeService.getDataListEmployee()) {
                str += item.getIdEmployee() + "," + item.getName() + "," +
                        item.getAddress() + "," + item.getBirthDay() + "," +
                        item.getPhone() + "," + item.getEmail() + "," +
                        item.getGender() + "," + item.getDocument() + "," +
                        item.getSalary() + "," + item.getAcademicLevel() + "," +
                        item.getPosition();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File employee.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataListCustomer () {
        try {
            File file = new File("src\\_case_study\\data\\customer.csv");
            if (! file.exists()) throw new FileNotFoundException("File not found");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Customer item : customerService.getDataListCustomer()) {
                str += item.getIdCustomer() + "," + item.getName() + "," +
                        item.getAddress() + "," + item.getBirthDay() + "," +
                        item.getPhone() + "," + item.getEmail() + "," +
                        item.getGender() + "," + item.getDocument() + "," +
                        item.getCustomerType();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File customer.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataListFacility (Map<Facility, Integer> list, String fileName) {
        try {
            File file = new File("src\\_case_study\\data\\" + fileName);
            if (! file.exists()) throw new FileNotFoundException("File not found");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Map.Entry<Facility, Integer> item : list.entrySet()) {
                str += item.getKey().getIdService() + "," + item.getKey().getNameService() + "," +
                       item.getKey().getArea() + "," + item.getKey().getPrice() + "," +
                       item.getKey().getMaximumPerson() + "," + item.getKey().getTypeOfBorrow();
                if (item instanceof House)
                    str += ((House) item.getKey()).getTypeOfRoom() + "," + ((House) item.getKey()).getNumberFloor() +
                            "," + item.getValue();
                if (item instanceof Villa)
                    str += ((Villa) item.getKey()).getAreaPool() + "," + ((Villa) item.getKey()).getTypeOfRoom() + "," +
                           ((Villa) item.getKey()).getNumberFloor() + "," + item.getValue();
                if (item instanceof Room)
                    str += ((Room) item.getKey()).getFreeService() + "," + item.getValue();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File facility.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataListBooking () {
        try {
            File file = new File("src\\_case_study\\data\\booking.csv");
            if (! file.exists()) throw new FileNotFoundException("File not found");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Booking item : bookingService.getDataListBooking()) {
                str += item.getIdBooking() + "," + item.getDateStart() + "," +
                        item.getDateEnd() + "," + item.getCustomer().getIdCustomer() + "," +
                        item.getFacility().getIdService();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File booking.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataListContract () {
        try {
            File file = new File("src\\_case_study\\data\\contract.csv");
            if (! file.exists()) throw new FileNotFoundException("File not found");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Contract item : contractService.getDataListContract()) {
                str += item.getNumberOfContract() + "," + item.getBooking().getIdBooking() + "," +
                        item.getDeposit() + "," + item.getTotalPay() + ",";
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File contract.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeDataListPromotion () {
        try {
            File file = new File("src\\_case_study\\data\\promotion.csv");
            if (! file.exists()) throw new FileNotFoundException("File not found");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Promotion item : promotionService.getDataListPromotion()) {
                str += item.getBooking().getIdBooking() + "," + item.getYearOfUse() + "," +
                        item.getVoucher();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("File promotion.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
