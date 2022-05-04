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
import java.util.*;

public class ReadData {
    private static final String FILE_EMPLOYEE = "src\\_case_study\\data\\employee.csv";
    private static final String FILE_CUSTOMER = "src\\_case_study\\data\\customer.csv";
    private static final String FILE_FACILITY = "src\\_case_study\\data\\facility.csv";
    private static final String FILE_BOOKING = "src\\_case_study\\data\\booking.csv";
    private static final String FILE_CONTRACT = "src\\_case_study\\data\\contract.csv";
    private static final String FILE_PROMOTION = "src\\_case_study\\data\\promotion.csv";
    private static final String FILE_FACILITYMAINTENANCE = "src\\_case_study\\data\\facility_maintenance.csv";

//    public static void readAllData () {
//        readDataEmployee();
//        readDataCustomer();
//        readDataFacility("FILE_FACILITY");
//        readDataFacility("FILE_FACILITYMAINTENANCE");
//        readDataBooking();
//        readDataContract();
//        readDataPromotion();
//    }

    public static List<Employee> readDataEmployee () {
        List<Employee> tempData = new ArrayList<>();
        try {
            File file = new File(FILE_EMPLOYEE);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            String[] obj;
            Employee employee;
            while ((str = bufferedReader.readLine()) != null && ! str.equals("")) {
                obj = str.split(",");
                employee = new Employee(obj[1] , obj[2] , obj[3] , obj[4] , obj[5] ,
                        obj[6] , obj[7] , obj[0] , Double.parseDouble(obj[8]) , obj[9] , obj[10]);
                tempData.add(employee);
            }
//            System.out.println("Success read Employee");
            bufferedReader.close();
            fileReader.close();
            return tempData;
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException employee.csv");
        } catch (IOException e) {
            System.err.println("IOException employee.csv");
        }
        return null;
    }

    public static List<Customer> readDataCustomer () {
        List<Customer> tempData = new LinkedList<>();
        try {
            File file = new File(FILE_CUSTOMER);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            String[] obj;
            Customer customer;
            while ((str = bufferedReader.readLine()) != null && ! str.equals("")) {
                obj = str.split(",");
                customer = new Customer(obj[1] , obj[2] , obj[3] , obj[4] , obj[5] ,
                        obj[6] , obj[7] , obj[0] , obj[8]);
                tempData.add(customer);
            }
//            System.out.println("Success read Customer");
            bufferedReader.close();
            fileReader.close();
            return tempData;
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException customer.csv");
        } catch (IOException e) {
            System.err.println("IOException customer.csv");
        }
        return null;
    }

    public static Map<Facility, Integer> readDataFacility (String filePath) {
        Map<Facility, Integer> tempData = new LinkedHashMap<>();
        File file = null;
        try {
            if (filePath.equals("FILE_FACILITY")) file = new File(FILE_FACILITY);
            else file = new File(FILE_FACILITYMAINTENANCE);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            String[] obj;
            Facility facility;
            while ((str = bufferedReader.readLine()) != null && ! str.equals("")) {
                obj = str.split(",");
                if (obj[0].substring(0 , obj[0].indexOf("-")).equals("SVVL")) {
                    facility = new Villa(obj[0] , Double.parseDouble(obj[2]) , Integer.parseInt(obj[3]) ,
                            Integer.parseInt(obj[4]) , obj[1] , obj[5] , obj[7] ,
                            Double.parseDouble(obj[6]) , Integer.parseInt(obj[8]));
                    tempData.put(facility , Integer.parseInt(obj[9]));
                } else if (obj[0].substring(0 , obj[0].indexOf("-")).equals("SVHO")) {
                    facility = new House(obj[0] , Double.parseDouble(obj[2]) , Integer.parseInt(obj[3]) ,
                            Integer.parseInt(obj[4]) , obj[1] , obj[5] , obj[6] , Integer.parseInt(obj[7]));
                    tempData.put(facility , Integer.parseInt(obj[8]));
                } else if (obj[0].substring(0 , obj[0].indexOf("-")).equals("SVRO")) {
                    facility = new Room(obj[0] , Double.parseDouble(obj[2]) , Integer.parseInt(obj[3]) ,
                            Integer.parseInt(obj[4]) , obj[1] , obj[5] , obj[6]);
                    tempData.put(facility , Integer.parseInt(obj[7]));
                }
            }
//            System.out.println("Success read facility");
            bufferedReader.close();
            fileReader.close();
            return tempData;
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException facility.csv");
        } catch (IOException e) {
            System.err.println("IOException facility.csv");
        }
        return null;
    }

    public static Set<Booking> readDataBooking () {
        Set<Booking> tempData = new TreeSet<>(new BookingComparator());
        try {
            File file = new File(FILE_BOOKING);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            String[] obj;
            Booking booking;
            while ((str = bufferedReader.readLine()) != null && ! str.equals("")) {
                obj = str.split(",");
                booking = new Booking(obj[1] , obj[2] , obj[0] ,
                        FuramaController.customerService.getCustomer(obj[3]) ,
                        FuramaController.facilityService.getFacility(obj[4]), Boolean.parseBoolean(obj[5]));
                tempData.add(booking);
            }
//            System.out.println("Success read booking");
            bufferedReader.close();
            fileReader.close();
            return tempData;
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException booking.csv");
        } catch (IOException e) {
            System.err.println("IOException booking.csv");
        }
        return null;
    }

    public static List<Contract> readDataContract () {
        List<Contract> tempData = new ArrayList<>();
        try {
            File file = new File(FILE_CONTRACT);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            String[] obj;
            Contract contract;
            while ((str = bufferedReader.readLine()) != null && ! str.equals("")) {
                obj = str.split(",");
                contract = new Contract(FuramaController.bookingService.getBooking(obj[1]) , obj[0] ,
                        Integer.parseInt(obj[2]) , Integer.parseInt(obj[3]), Boolean.parseBoolean(obj[4]));
                tempData.add(contract);
            }
//            System.out.println("Success read contract");
            bufferedReader.close();
            fileReader.close();
            return tempData;
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException contract.csv");
        } catch (IOException e) {
            System.err.println("IOException contract.csv");
        }
        return null;
    }

    public static Set<Promotion> readDataPromotion () {
        Set<Promotion> tempData = new TreeSet<>();
        try {
            File file = new File(FILE_PROMOTION);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            String[] obj;
            Promotion promotion;
            while ((str = bufferedReader.readLine()) != null && ! str.equals("")) {
                obj = str.split(",");
                promotion = new Promotion(FuramaController.contractService.getContract(obj[0]) ,
                        Integer.parseInt(obj[1]) , obj[2]);
                tempData.add(promotion);
            }
//            System.out.println("Success read promotion");
            bufferedReader.close();
            fileReader.close();
            return tempData;
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException promotion.csv");
        } catch (IOException e) {
            System.err.println("IOException promotion.csv");
        }
        return null;
    }
}
