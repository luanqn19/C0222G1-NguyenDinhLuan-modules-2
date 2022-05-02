package _case_study.utils;

import _case_study.controller.FuramaController;
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
    private static final String FILE_EMPLOYEE = "src\\_case_study\\data\\employee.csv";
    private static final String FILE_CUSTOMER = "src\\_case_study\\data\\customer.csv";
    private static final String FILE_BOOKING = "src\\_case_study\\data\\booking.csv";
    private static final String FILE_CONTRACT = "src\\_case_study\\data\\contract.csv";
    private static final String FILE_PROMOTION = "src\\_case_study\\data\\promotion.csv";

    private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;

//    public static void writeAllData () {
//        writeDataListEmployee();
//        writeDataListCustomer();
//        writeDataListFacility(facilityService.getDataFacility() , "facility.csv");
//        writeDataListFacility(facilityService.getDataFacilityMaintenance() , "facility_maintenance.csv");
//        writeDataListBooking();
//        writeDataListContract();
//        writeDataListPromotion();
//    }

    public static void writeDataListEmployee () {
        try {
            file = new File(FILE_EMPLOYEE);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Employee item : FuramaController.employeeService.getDataListEmployee()) {
                str += item.getIdEmployee() + "," + item.getName() + "," +
                        item.getAddress() + "," + item.getBirthDay() + "," +
                        item.getPhone() + "," + item.getEmail() + "," +
                        item.getGender() + "," + item.getDocument() + "," +
                        item.getSalary() + "," + item.getAcademicLevel() + "," +
                        item.getPosition();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                str = "";
            }
            System.out.println("Success write Employee");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File employee.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataListCustomer () {
        try {
            file = new File(FILE_CUSTOMER);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Customer item : FuramaController.customerService.getDataListCustomer()) {
                str += item.getIdCustomer() + "," + item.getName() + "," +
                        item.getAddress() + "," + item.getBirthDay() + "," +
                        item.getPhone() + "," + item.getEmail() + "," +
                        item.getGender() + "," + item.getDocument() + "," +
                        item.getCustomerType();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                str = "";
            }
            System.out.println("Success write Customer");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File customer.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataListFacility (Map<Facility, Integer> list , String fileName) {
        try {
            file = new File("src\\_case_study\\data\\" + fileName);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Map.Entry<Facility, Integer> item : list.entrySet()) {
                str += item.getKey().getIdService() + "," + item.getKey().getNameService() + "," +
                        item.getKey().getArea() + "," + item.getKey().getPrice() + "," +
                        item.getKey().getMaximumPerson() + "," + item.getKey().getTypeOfBorrow() + ",";
                if (item.getKey().getIdService().substring(0 , item.getKey().getIdService().indexOf("-")).equals("SVHO"))
                    str += ((House) item.getKey()).getTypeOfRoom() + "," + ((House) item.getKey()).getNumberFloor() +
                            "," + item.getValue();
                else if (item.getKey().getIdService().substring(0 , item.getKey().getIdService().indexOf("-")).equals("SVVL"))
                    str += ((Villa) item.getKey()).getAreaPool() + "," + ((Villa) item.getKey()).getTypeOfRoom() + "," +
                            ((Villa) item.getKey()).getNumberFloor() + "," + item.getValue();
                else if (item.getKey().getIdService().substring(0 , item.getKey().getIdService().indexOf("-")).equals("SVRO"))
                    str += ((Room) item.getKey()).getFreeService() + "," + item.getValue();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                str = "";
            }
            System.out.println("Success write Facility");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File facility.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataListBooking () {
        try {
            file = new File(FILE_BOOKING);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Booking item : FuramaController.bookingService.getDataListBooking()) {
                str += item.getIdBooking() + "," + item.getDateStart() + "," +
                        item.getDateEnd() + "," + item.getCustomer().getIdCustomer() + "," +
                        item.getFacility().getIdService() + "," + item.isCreateContrat();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                str = "";
            }
            System.out.println("Success write Booking");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File booking.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataListContract () {
        try {
            file = new File(FILE_CONTRACT);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Contract item : FuramaController.contractService.getDataListContract()) {
                str += item.getNumberOfContract() + "," + item.getBooking().getIdBooking() + "," +
                        item.getDeposit() + "," + item.getTotalPay();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                str = "";
            }
            System.out.println("Success write Contract");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File contract.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataListPromotion () {
        try {
            file = new File(FILE_PROMOTION);
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = "";
            for (Promotion item : FuramaController.promotionService.getDataListPromotion()) {
                str += item.getContract().getNumberOfContract() + "," + item.getYearOfUse() + "," +
                        item.getVoucher();
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                str = "";
            }
            System.out.println("Success write Promotion");
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File promotion.csv not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
